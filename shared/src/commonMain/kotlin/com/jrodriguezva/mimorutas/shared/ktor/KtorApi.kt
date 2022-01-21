package com.jrodriguezva.mimorutas.shared.ktor

import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult

interface KtorApi {
    suspend fun getGeoJson(sigren: String): GeoJsonServerResult
}
