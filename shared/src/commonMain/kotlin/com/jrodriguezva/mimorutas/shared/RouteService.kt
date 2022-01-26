package com.jrodriguezva.mimorutas.shared

import com.jrodriguezva.mimorutas.shared.ktor.IdecylApiImpl
import com.jrodriguezva.mimorutas.shared.ktor.KtorApi
import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import com.jrodriguezva.mimorutas.shared.models.DataState
import com.jrodriguezva.mimorutas.shared.models.Route
import kotlinx.serialization.ExperimentalSerializationApi


@OptIn(ExperimentalSerializationApi::class)
class RouteService {
    private val ktorApi: KtorApi = IdecylApiImpl()
    fun getRoutes(): List<Route> {
        return listOf(
            Route("Espacios naturales", "espacio"),
            Route("Aparcamientos", "aparcamiento"),
            Route("Rutas disponibles", "senda"),
            Route("Zonas de acampada", "zona_acamp"),
            Route("Campamentos", "campamento"),
        )
    }

    suspend fun getRoute(sigren: String): DataState<GeoJsonServerResult> {
        val breedResult = ktorApi.getGeoJson(sigren)

        val feature = breedResult.features
        return if (feature?.isEmpty() == true) {
            DataState(empty = true)
        } else {
            DataState(breedResult)
        }

    }
}


