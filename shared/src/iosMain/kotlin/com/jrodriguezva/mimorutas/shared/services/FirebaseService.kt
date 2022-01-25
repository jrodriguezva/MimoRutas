package  com.jrodriguezva.mimorutas.shared.services

import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.database.database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapNotNull

private const val PATH = "favorites"


actual object FirebaseService {
    actual suspend fun saveFavorite(itemId: String, feature: GeoJsonServerResult.Feature) {

    }

    actual suspend fun removeFavorite(itemId: String, feature: GeoJsonServerResult.Feature) {

    }

    actual fun getFavoritesRoutesById(routeId: String, itemId: Int): Flow<GeoJsonServerResult.Feature> =
       flow { }

    actual fun getFavoritesRoutes(itemId: String): Flow<List<GeoJsonServerResult.Feature>> = flow {  }
}
