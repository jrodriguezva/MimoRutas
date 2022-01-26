package com.jrodriguezva.mimorutas.shared.services

import com.jrodriguezva.mimorutas.shared.models.User

expect object AuthService {

    suspend fun login(email: String, pass: String): User?

    suspend fun register(name: String, email: String, pass: String): User?

    fun checkUserLogged(): Boolean

}