package com.jrodriguezva.mimorutas.shared

import com.jrodriguezva.mimorutas.shared.ktor.IdecylApiImpl
import com.jrodriguezva.mimorutas.shared.ktor.KtorApi
import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import com.jrodriguezva.mimorutas.shared.models.DataState
import com.jrodriguezva.mimorutas.shared.models.Space
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString


@OptIn(ExperimentalSerializationApi::class)
object RouteService {
    private val ktorApi: KtorApi = IdecylApiImpl()

    fun getAllSpaces(): List<Space> {
        return listOf(
            Space("Espacios naturales", "espacio"),
            Space("Aparcamientos", "aparcamiento"),
            Space("Rutas disponibles", "senda"),
            Space("Zonas de acampada", "zona_acamp"),
            Space("Campamentos", "campamento"),
        )
    }

    suspend fun getRoute(sigren: String): DataState<GeoJsonServerResult> {
        val breedResult = ktorApi.getGeoJson(sigren)

        val feature = breedResult.features
        val full = breedResult.copy(features = breedResult.features?.filter { it.geometry != null })
        return if (feature?.isEmpty() == true) {
            DataState(empty = true, loading = false)
        } else {
            DataState(full, loading = false)
        }

    }
}


