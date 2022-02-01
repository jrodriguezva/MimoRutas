package com.jrodriguezva.mimorutas.shared.viewmodel

import com.jrodriguezva.mimorutas.shared.models.DataState
import com.jrodriguezva.mimorutas.shared.services.AuthService
import io.github.aakira.napier.Napier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val onDataState: (DataState<Boolean>) -> Unit
) {
    private val log: Napier = Napier
    private val scope = MainScope(Dispatchers.Main, log)
    private val _stateFlow: MutableStateFlow<DataState<Boolean>> = MutableStateFlow(
        DataState(loading = true)
    )

    init {
        if (AuthService.checkUserLogged()) {
            val temp = _stateFlow.value.copy(loading = true)
            _stateFlow.value = temp
        }
    }

    @OptIn(FlowPreview::class)
    fun register(user: String, email: String, pass: String) {
        scope.launch {
            log.v { "Register" }
            _stateFlow.value = _stateFlow.value.copy(loading = true)
            if (AuthService.register(user, email, pass) != null) {
                _stateFlow.value = _stateFlow.value.copy(loading = false, data = true)
            } else {
                _stateFlow.value = _stateFlow.value.copy(loading = false, exception = "User error")
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
