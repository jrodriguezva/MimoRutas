package com.jrodriguezva.mimorutas.shared.ktor.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeoJsonServerResult(
    @SerialName("bbox")
    val bbox: List<Double?>?,
    @SerialName("crs")
    val crs: Crs?,
    @SerialName("features")
    val features: List<Feature>?,
    @SerialName("numberMatched")
    val numberMatched: Int?,
    @SerialName("numberReturned")
    val numberReturned: Int?,
    @SerialName("timeStamp")
    val timeStamp: String?,
    @SerialName("totalFeatures")
    val totalFeatures: Int?,
    @SerialName("type")
    val type: String?
) {
    @Serializable
    data class Crs(
        @SerialName("properties")
        val properties: Properties?,
        @SerialName("type")
        val type: String?
    ) {
        @Serializable
        data class Properties(
            @SerialName("name")
            val name: String?
        )
    }

    @Serializable
    data class Feature(
        @SerialName("bbox")
        val bbox: List<Double?>? = emptyList(),
        @SerialName("geometry")
        val geometry: Geometry? = null,
        @SerialName("geometry_name")
        val geometryName: String? = null,
        @SerialName("id")
        val id: String? = null,
        @SerialName("properties")
        val properties: Properties? = null,
        @SerialName("type")
        val type: String? = null
    ) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            other as Feature
            if (other.properties == this.properties) return true
            return super.equals(other)
        }

        override fun hashCode(): Int {
            var result = bbox?.hashCode() ?: 0
            result = 31 * result + (geometry?.hashCode() ?: 0)
            result = 31 * result + (geometryName?.hashCode() ?: 0)
            result = 31 * result + (id?.hashCode() ?: 0)
            result = 31 * result + (properties?.hashCode() ?: 0)
            result = 31 * result + (type?.hashCode() ?: 0)
            return result
        }

        @Serializable(with = GeometrySerializer::class)
        data class Geometry(
            @SerialName("type")
            val type: String? = null,
            @SerialName("coordinates")
            val coordinates: Any = ""
        )

        @Serializable
        data class Properties(
            @SerialName("atr_gr_alerta")
            val atrGrAlerta: Boolean? = null,
            @SerialName("atr_gr_id")
            val atrGrId: Int? = null,
            @SerialName("atr_gr_tiene_q")
            val atrGrTieneQ: Boolean? = null,
            @SerialName("atr_gr_tipo")
            val atrGrTipo: Int? = null,
            @SerialName("atr_gr_visible")
            val atrGrVisible: Boolean? = null,
            @SerialName("espacio_codigo")
            val espacioCodigo: String? = null,
            @SerialName("espacio_fecha_declaracion")
            val espacioFechaDeclaracion: String? = null,
            @SerialName("espacio_nombre")
            val espacioNombre: String? = null,
            @SerialName("espacio_senalizacion_externa")
            val espacioSenalizacionExterna: Boolean? = null,
            @SerialName("figura")
            val figura: Int? = null,
            @SerialName("figura_nombre")
            val figuraNombre: String? = null,
            @SerialName("rutaimg")
            val rutaimg: String? = null,
            @SerialName("acc_dis_id")
            val accDisId: Int? = null,
            @SerialName("acc_id")
            val accId: Int? = null,
            @SerialName("campamento_cabanas")
            val campamentoCabanas: Int? = null,
            @SerialName("campamento_categoria")
            val campamentoCategoria: Int? = null,
            @SerialName("campamento_juvenil")
            val campamentoJuvenil: Boolean? = null,
            @SerialName("campamento_parcelas")
            val campamentoParcelas: Int? = null,
            @SerialName("campamento_servicio_informativo")
            val campamentoServicioInformativo: Boolean? = null,
            @SerialName("cerramiento_id")
            val cerramientoId: Int? = null,
            @SerialName("cerramiento_material_id")
            val cerramientoMaterialId: Int? = null,
            @SerialName("equip_a_codigo")
            val equipACodigo: String? = null,
            @SerialName("equip_a_estado_fecha")
            val equipAEstadoFecha: String? = null,
            @SerialName("equip_a_fecha_declaracion")
            val equipAFechaDeclaracion: String? = null,
            @SerialName("equip_a_observaciones")
            val equipAObservaciones: String? = null,
            @SerialName("equip_b_acceso_modo")
            val equipBAccesoModo: String? = null,
            @SerialName("equip_b_nombre")
            val equipBNombre: String? = null,
            @SerialName("equip_b_senalizacion_ext")
            val equipBSenalizacionExt: Boolean? = null,
            @SerialName("equip_b_superficie_aprox")
            val equipBSuperficieAprox: Int? = null,
            @SerialName("equip_b_tiene_interes")
            val equipBTieneInteres: Boolean? = null,
            @SerialName("estado_id")
            val estadoId: Int? = null,
            @SerialName("web")
            val web: String? = null
        )
    }
}