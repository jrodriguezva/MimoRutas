package com.jrodriguezva.mimorutas.shared

import com.jrodriguezva.mimorutas.shared.ktor.IdecylApiImpl
import com.jrodriguezva.mimorutas.shared.ktor.KtorApi
import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import com.jrodriguezva.mimorutas.shared.models.DataState
import com.jrodriguezva.mimorutas.shared.models.Route
import com.jrodriguezva.mimorutas.shared.models.User
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.database.database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.serialization.ExperimentalSerializationApi


@OptIn(ExperimentalSerializationApi::class)
object RouteService {
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

object FirebaseService {
    private val database = Firebase.database.reference("")
    private val auth = Firebase.auth
    private const val PATH = "favorites"

    suspend fun saveFavorite(itemId: String, feature: GeoJsonServerResult.Feature) {
        auth.currentUser?.uid?.let {
            database.child(PATH).child(it).child(itemId).child("${feature.properties?.atrGrId ?: -1}").setValue(feature)
        }
    }

    suspend fun removeFavorite(itemId: String, feature: GeoJsonServerResult.Feature) {
        auth.currentUser?.uid?.let {
            database.child(PATH).child(it).child(itemId).child("${feature.properties?.atrGrId ?: -1}").removeValue()
        }
    }

    fun getFavoritesRoutesById(routeId: String,itemId: Int): Flow<GeoJsonServerResult.Feature> =
        database.child(PATH).child(auth.currentUser?.uid!!).child(routeId).child(itemId.toString()).valueEvents.mapNotNull {
                it.value() as? GeoJsonServerResult.Feature
        }

    fun getFavoritesRoutes(itemId: String): Flow<List<GeoJsonServerResult.Feature>> =
        database.child(PATH).child(auth.currentUser?.uid!!).child(itemId).valueEvents.mapNotNull {
            it.children.map { child ->
                child.value() as GeoJsonServerResult.Feature
            }
        }

}


object AuthService {
    private val auth = Firebase.auth
    suspend fun login(email: String, pass: String): User? {
        return try {
            val result = auth.signInWithEmailAndPassword(email, pass)
            result.user?.run {
                User(displayName.orEmpty(), email)
            }
        } catch (e: Exception) {
            null
        }
    }

    suspend fun register(name: String, email: String, pass: String): User? {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, pass)
            result.user?.run {
                updateProfile(name)
                User(name, email)
            }
        } catch (e: Exception) {
            null
        }
    }

    fun checkUserLogged(): Boolean {
        val currentUser = auth.currentUser
        return currentUser != null
    }

}