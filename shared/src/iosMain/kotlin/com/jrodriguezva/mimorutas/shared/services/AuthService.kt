package com.jrodriguezva.mimorutas.shared.services

import com.jrodriguezva.mimorutas.shared.models.User

actual object AuthService {

    actual suspend fun login(email: String, pass: String): User? {
        return User("", "")

    }

    actual suspend fun register(name: String, email: String, pass: String): User? {
        return User("", "")
    }

    actual fun checkUserLogged(): Boolean {
        return true
    }

}