package com.jrodriguezva.mimorutas.shared.viewmodel

import com.jrodriguezva.mimorutas.shared.RouteService
import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import com.jrodriguezva.mimorutas.shared.models.DataState
import com.jrodriguezva.mimorutas.shared.services.AuthService
import io.github.aakira.napier.Napier
import io.ktor.http.ContentType.Application.Json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString

class DetailViewModel(
    private val onDataState: (DataState<Pair<GeoJsonServerResult, String>>) -> Unit
) {
    private val log: Napier = Napier
    private val scope = MainScope(Dispatchers.Main, log)
    private val _stateFlow: MutableStateFlow<DataState<Pair<GeoJsonServerResult, String>>> =
        MutableStateFlow(
            DataState(loading = true)
        )

    init {
        if (AuthService.checkUserLogged()) {
            val temp = _stateFlow.value.copy(loading = true)
            _stateFlow.value = temp
        }
    }

    fun getRoute(sigren: String) {
        scope.launch {
            log.v { "Authentication" }
            _stateFlow.value = _stateFlow.value.copy(loading = true)
            RouteService.getRoute(sigren).data?.let { data ->
                val str = kotlinx.serialization.json.Json.encodeToString(data)
                _stateFlow.value = _stateFlow.value.copy(loading = false, data = data to str)
            }
        }
        scope.launch {
            log.v { "Exposing flow through callbacks" }
            _stateFlow.collect { dataState ->
                onDataState(dataState)
            }
        }
    }

    fun onDestroy() {
        scope.onDestroy()
    }
}
