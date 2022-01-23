package com.jrodriguezva.mimorutas.shared.ktor

import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.takeFrom
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
            sigren("typeNames=sigren:$sigren")
        }.body()
    }

    private fun HttpRequestBuilder.sigren(path: String) {
        url {
            takeFrom("https://idecyl.jcyl.es/geoserver/sigren/wfs?service=WFS&version=1.1.0&request=GetFeature&outputFormat=JSON&srsName=EPSG:4326&$path")
        }
    }
}
