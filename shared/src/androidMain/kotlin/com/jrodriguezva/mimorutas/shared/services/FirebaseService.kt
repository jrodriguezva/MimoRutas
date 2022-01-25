package com.jrodriguezva.mimorutas.shared.services

import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.database.database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

private val database = Firebase.database.reference("")
private val auth = Firebase.auth
private const val PATH = "favorites"


actual object FirebaseService {
    actual suspend fun saveFavorite(itemId: String, feature: GeoJsonServerResult.Feature) {
        auth.currentUser?.uid?.let {
            database.child(PATH).child(it).child(itemId).child("${feature.properties?.atrGrId ?: -1}").setValue(feature)
        }
    }

    actual suspend fun removeFavorite(itemId: String, feature: GeoJsonServerResult.Feature) {
        auth.currentUser?.uid?.let {
            database.child(PATH).child(it).child(itemId).child("${feature.properties?.atrGrId ?: -1}").removeValue()
        }
    }

    actual fun getFavoritesRoutesById(routeId: String, itemId: Int): Flow<GeoJsonServerResult.Feature> =
        database.child(PATH).child(auth.currentUser?.uid!!).child(routeId).child(itemId.toString()).valueEvents.mapNotNull {
            it.value() as? GeoJsonServerResult.Feature
        }

    actual fun getFavoritesRoutes(itemId: String): Flow<List<GeoJsonServerResult.Feature>> =
        database.child(PATH).child(auth.currentUser?.uid!!).child(itemId).valueEvents.mapNotNull {
            it.children.map { child ->
                child.value() as GeoJsonServerResult.Feature
            }
        }
}
