package  com.jrodriguezva.mimorutas.shared.services

import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

private const val PATH = "favorites"


actual object FirebaseService {
    actual suspend fun saveFavorite(itemId: String, feature: GeoJsonServerResult.Feature) {

    }

    actual suspend fun removeFavorite(itemId: String, feature: GeoJsonServerResult.Feature) {

    }

    actual fun getFavoritesRoutesById(
        routeId: String,
        itemId: Int
    ): Flow<GeoJsonServerResult.Feature> =
        flow { }

    actual fun getFavoritesRoutes(itemId: String): Flow<List<GeoJsonServerResult.Feature>> =
        flow { }
}
