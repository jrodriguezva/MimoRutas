package com.jrodriguezva.mimorutas.shared.ktor

import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@ExperimentalSerializationApi
class IdecylApiImpl : KtorApi {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                explicitNulls = false
                prettyPrint = true
                isLenient = true
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
            url("https://idecyl.jcyl.es/geoserver/sigren/wfs")
            parameter("service", "WFS")
            parameter("version", "1.1.0")
            parameter("request", "GetFeature")
            parameter("outputFormat", "JSON")
            parameter("srsName", "EPSG:4326")
            parameter("typeNames", "sigren:$sigren")
        }.body()

    }
}
