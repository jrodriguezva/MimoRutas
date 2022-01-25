package com.jrodriguezva.mimorutas.androidApp.ui.login

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrodriguezva.mimorutas.androidApp.R
import com.jrodriguezva.mimorutas.shared.services.AuthService
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    var state by mutableStateOf(UiState())

    data class UiState(
        val loggedIn: Boolean = false,
        val loading: Boolean = false,
        @StringRes val error: Int? = null
    )

    fun registerClicked(name: String, user: String, pass: String) {
        when {
            !user.contains('@') -> state = UiState(error = R.string.wrong_username)
            pass.length < 5 -> state = UiState(error = R.string.wrong_username)
            pass.length < 5 -> state = UiState(error = R.string.short_password)
            else -> doRegister(name, user, pass)
        }
    }


    private fun doRegister(name: String, user: String, pass: String) {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = if (AuthService.register(name, user, pass) != null) {
                Log.e("TAG", "doLogin")
                UiState(loading = false, loggedIn = true)
            } else {
                Log.e("TAG", "error")
                UiState(loading = false, error = R.string.wrong_username)
            }
        }
    }

}