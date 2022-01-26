package com.jrodriguezva.mimorutas.shared.services

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import com.jrodriguezva.mimorutas.shared.models.User

actual object AuthService {

    private val auth = Firebase.auth

    actual suspend fun login(email: String, pass: String): User? {
        return try {
            val result = auth.signInWithEmailAndPassword(email, pass)
            result.user?.run {
                User(displayName.orEmpty(), email)
            }
        } catch (e: Exception) {
            null
        }
    }

    actual suspend fun register(name: String, email: String, pass: String): User? {
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

    actual fun checkUserLogged(): Boolean {
        val currentUser = auth.currentUser
        return currentUser != null
    }

}