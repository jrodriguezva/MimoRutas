package com.jrodriguezva.mimorutas.androidApp.ui.routes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jrodriguezva.mimorutas.androidApp.R
import com.jrodriguezva.mimorutas.shared.ktor.response.GeoJsonServerResult

@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoritesScreen(
    bottomBar: @Composable () -> Unit,
    viewModel: MainDetailViewModel,
    onBackPressed: () -> Unit = {}
) {
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
            MapCardList(favorites.value) {
                property.value = it.properties!!
                openDialog.value = true
            }

            DialogProperty(openDialog, property)
        }
    )
}

@Composable
fun DialogProperty(
    openDialog: MutableState<Boolean>,
    property: MutableState<GeoJsonServerResult.Feature.Properties>
) {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = property.value.espacioNombre ?: property.value.equipBNombre.orEmpty())
            },
            text = {
                Column {
                    if (property.value.equipBAccesoModo != null) Text("Accesso: ${property.value.equipBAccesoModo}")
                    if (property.value.equipBSuperficieAprox != null) Text("Superficie Aprox: ${property.value.equipBSuperficieAprox}")
                    Text("Observaciones: ${property.value.equipAObservaciones.orEmpty()}")
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Cerrar")
                }
            }
        )
    }
}


@ExperimentalMaterialApi
@Composable
private fun MapCardList(
    featuresFavorites: List<GeoJsonServerResult.Feature>,
    onItemClick: (GeoJsonServerResult.Feature) -> Unit
) {
    LazyColumn {
        items(featuresFavorites) { feature ->
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 16.dp, 16.dp, 0.dp)
                    .clickable { },
                onClick = { onItemClick(feature) },
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
                        tint = Color.Red,
                        modifier = Modifier.padding(24.dp),
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = null
                    )

                }
            }
        }

    }
}