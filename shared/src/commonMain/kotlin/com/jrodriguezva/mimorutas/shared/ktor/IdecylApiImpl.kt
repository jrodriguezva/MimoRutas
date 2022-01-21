package com.jrodriguezva.mimorutas.shared.ktor

import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import io.ktor.client.HttpClient
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.takeFrom
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@ExperimentalSerializationApi
class IdecylApiImpl : KtorApi {

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json {
                ignoreUnknownKeys = true
                explicitNulls = false
            })
        }

        install(HttpTimeout) {
            val timeout = 30000L
            connectTimeoutMillis = timeout
            requestTimeoutMillis = timeout
            socketTimeoutMillis = timeout
        }
    }

    override suspend fun getGeoJson(sigren: String): GeoJsonServerResult {
        return client.get {
            sigren("typeNames=sigren:$sigren")
        }
    }

    private fun HttpRequestBuilder.sigren(path: String) {
        url {
            takeFrom("https://idecyl.jcyl.es/geoserver/sigren/wfs?service=WFS&version=1.1.0&request=GetFeature&outputFormat=JSON&srsName=EPSG:4326&$path")
        }
    }
}
