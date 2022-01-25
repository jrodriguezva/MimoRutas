package com.jrodriguezva.mimorutas.shared.services

import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import kotlinx.coroutines.flow.Flow

expect object FirebaseService {

    suspend fun saveFavorite(itemId: String, feature: GeoJsonServerResult.Feature)

    suspend fun removeFavorite(itemId: String, feature: GeoJsonServerResult.Feature)

    fun getFavoritesRoutesById(routeId: String, itemId: Int): Flow<GeoJsonServerResult.Feature>

    fun getFavoritesRoutes(itemId: String): Flow<List<GeoJsonServerResult.Feature>>

}