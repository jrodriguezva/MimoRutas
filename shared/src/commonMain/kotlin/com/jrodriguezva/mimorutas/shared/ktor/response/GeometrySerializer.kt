package com.jrodriguezva.mimorutas.shared.ktor.response

import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult.Feature.Geometry
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.serialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.serializer

object GeometrySerializer : KSerializer<Geometry> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Geometry") {
        element("type", serialDescriptor<String>())
        element("coordinates", buildClassSerialDescriptor("Any"))
    }

    @Suppress("UNCHECKED_CAST")
    private val dataTypeSerializers: Map<String, KSerializer<Any>> =
        mapOf(
            "Point" to serializer<List<Double>>(),
            "LineString" to serializer<List<List<Double>>>(),
            "Polygon" to serializer<List<List<List<Double>>>>(),
            "MultiPoint" to serializer<List<List<Double>>>(),
            "MultiLineString" to serializer<List<List<List<Double>>>>(),
            "MultiPolygon" to serializer<List<List<List<List<Double>>>>>(),
        ).mapValues { (_, v) -> v as KSerializer<Any> }

    private fun getPayloadSerializer(dataType: String?): KSerializer<Any> = dataTypeSerializers[dataType]
        ?: throw SerializationException("Serializer for class $dataType is not registered in GeometrySerializer")

    override fun serialize(encoder: Encoder, value: Geometry) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value.type.orEmpty())
            encodeSerializableElement(descriptor, 1, getPayloadSerializer(value.type), value.coordinates)
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun deserialize(decoder: Decoder): Geometry = decoder.decodeStructure(descriptor) {
        if (decodeSequentially()) {
            val dataType = decodeStringElement(descriptor, 0)
            val payload = decodeSerializableElement(descriptor, 1, getPayloadSerializer(dataType))
            Geometry(dataType, payload)
        } else {
            require(decodeElementIndex(descriptor) == 0) { "dataType field should precede payload field" }
            val dataType = decodeStringElement(descriptor, 0)
            val payload = when (val index = decodeElementIndex(descriptor)) {
                1 -> decodeSerializableElement(descriptor, 1, getPayloadSerializer(dataType))
                CompositeDecoder.DECODE_DONE -> throw SerializationException("payload field is missing")
                else -> error("Unexpected index: $index")
            }
            Geometry(dataType, payload)
        }
    }
}