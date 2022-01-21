package com.jrodriguezva.mimorutas.androidApp.ui.routes

import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.maps.android.data.geojson.GeoJsonFeature
import com.jrodriguezva.mimorutas.androidApp.ui.navigation.NavArgs
import com.jrodriguezva.mimorutas.shared.RouteService
import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RoutesDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val sigren: String? = savedStateHandle[NavArgs.ItemId.key]
    val title: String? = savedStateHandle[NavArgs.Title.key]

    var state by mutableStateOf(UiState())

    val location = mutableStateOf<Location?>(null)
    var layersFeatures: Sequence<GeoJsonFeature>? = null
    private val zoomLevel = MutableStateFlow<Float>(15.0f)

    fun setZoomLevel(zl: Float) {
        zoomLevel.value = zl
    }

    fun getZoomLevel(): Float {
        return zoomLevel.value ?: 15.0f
    }

    fun setLocation(loc: Location) {
        location.value = loc
        state = state.copy(location = loc)
    }

    data class UiState(
        val location: Location? = null,
        val data: GeoJsonServerResult? = null,
        val loading: Boolean = false,
        @StringRes val error: Int? = null
    )

    init {
        viewModelScope.launch {
            sigren?.let {
                val result = RouteService.getRoute(it)
                state = UiState(data = result.data)
            }
        }
    }

}