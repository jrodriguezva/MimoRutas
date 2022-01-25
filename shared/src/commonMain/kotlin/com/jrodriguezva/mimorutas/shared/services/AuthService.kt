package com.jrodriguezva.mimorutas.shared.services

import com.jrodriguezva.mimorutas.shared.models.User
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth

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