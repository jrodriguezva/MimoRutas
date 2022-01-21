package com.jrodriguezva.mimorutas.androidApp.ui.routes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import com.google.maps.android.data.geojson.GeoJsonLayer
import com.google.maps.android.ktx.awaitMap
import com.jrodriguezva.mimorutas.androidApp.R
import com.jrodriguezva.mimorutas.androidApp.getBoundsZoomLevel
import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult
import kotlinx.coroutines.launch
import org.json.JSONObject

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun RoutesDetail(
    viewModel: MainDetailViewModel = viewModel(),
    bottomBar: @Composable () -> Unit = {},
    onBackPressed: () -> Unit = {}
) {

    val state = viewModel.state
    val favorites = viewModel.favorites.collectAsState(initial = emptyList())
    val openDialog = remember { mutableStateOf(false) }
    val property = remember { mutableStateOf(GeoJsonServerResult.Feature.Properties()) }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(viewModel.title.orEmpty()) },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                })
        },
        bottomBar = bottomBar,
        content = {
            if (state.data != null) {
                Column {
                    state.data.let {
                        Box(modifier = Modifier.weight(0.4f)) {
                            CityMapView(viewModel, it)
                        }
                        Box(modifier = Modifier.weight(0.6f)) {
                            it.features?.let { features ->
                                MapCardList(features, favorites.value, { selected, isFavorite ->
                                    viewModel.layersFeatures?.firstOrNull { layer ->
                                        layer.id == selected.id
                                    }?.let { feature ->
                                        viewModel.setLocation(
                                            Location(
                                                feature.boundingBox.center.latitude,
                                                feature.boundingBox.center.longitude
                                            )
                                        )
                                        viewModel.setZoomLevel(feature.boundingBox.getBoundsZoomLevel().toFloat())
                                    }

                                    if (isFavorite) viewModel.removeFavorite(selected) else viewModel.saveFavorite(selected)
                                }, {
                                    property.value = it.properties!!
                                    openDialog.value = true
                                })
                            }
                        }
                    }
                }
                DialogProperty(openDialog, property)
            } else if (state.loading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    CircularProgressIndicator()
                }
            }
        })
}


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun MapCardList(
    features: List<GeoJsonServerResult.Feature>,
    featuresFavorites: List<GeoJsonServerResult.Feature>?,
    onItemClick: (GeoJsonServerResult.Feature, Boolean) -> Unit,
    onLongClick: (GeoJsonServerResult.Feature) -> Unit
) {
    LazyColumn {
        items(features) { feature ->
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 16.dp, 16.dp, 0.dp)
                    .combinedClickable(
                        onClick = { onItemClick(feature, featuresFavorites?.contains(feature) == true) },
                        onLongClick = { onLongClick(feature) },
                    ),


                backgroundColor = MaterialTheme.colorScheme.surfaceVariant

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {


                    Text(
                        text = feature.properties?.espacioNombre ?: feature.properties?.equipBNombre.orEmpty(),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier
                            .padding(24.dp)
                            .weight(1f),
                        style = MaterialTheme.typography.titleMedium
                    )

                    androidx.compose.material3.Icon(
                        tint = if (featuresFavorites?.contains(feature) == true) Color.Red else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(24.dp),
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = null
                    )

                }
            }
        }

    }
}

@Composable
private fun CityMapView(
    viewModel: MainDetailViewModel,
    data: GeoJsonServerResult
) {
    val mapView = rememberMapViewWithLifecycle()
    MapViewContainer(viewModel, mapView, data)
}

@Composable
private fun MapViewContainer(
    viewModel: MainDetailViewModel,
    map: MapView,
    data: GeoJsonServerResult,
) {
    val currentLocation = viewModel.location
    var firstTimeShowingMap by remember { mutableStateOf(true) }
    val coroutineScope = rememberCoroutineScope()

    AndroidView({ map }) { mapView ->
        coroutineScope.launch {
            val googleMap = mapView.awaitMap()
            if (firstTimeShowingMap) {
                firstTimeShowingMap = false
                val gsonData = JSONObject(Gson().toJson(data))
                val layer = GeoJsonLayer(googleMap, gsonData)
                viewModel.layersFeatures = layer.features.asSequence()
                layer.addLayerToMap()
            }
            currentLocation.value?.let {
                val position = LatLng(it.latitude, it.longitude)
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, viewModel.getZoomLevel()))
            }

            googleMap.setOnCameraIdleListener {
                val cameraPosition = googleMap.cameraPosition
                val location = Location(cameraPosition.target.latitude, cameraPosition.target.longitude)
                viewModel.setLocation(location)
                viewModel.setZoomLevel(cameraPosition.zoom)
            }
            googleMap.uiSettings.isZoomControlsEnabled = true
        }
    }
}


