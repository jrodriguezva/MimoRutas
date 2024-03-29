package com.jrodriguezva.mimorutas.shared.models

data class DataState<out T>(
    val data: T? = null,
    val exception: String? = null,
    val empty: Boolean = false,
    val loading: Boolean = false
)
