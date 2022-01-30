package com.jrodriguezva.mimorutas.androidApp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jrodriguezva.mimorutas.androidApp.R
import com.jrodriguezva.mimorutas.androidApp.ui.theme.AppTheme
import com.jrodriguezva.mimorutas.shared.models.Space

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun Routes(routes: List<Space>, onItemClick: (Space) -> Unit = {}) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Todos los espacios") },
            )
        },
        content = { innerPadding ->
            Column(
                Modifier.padding(innerPadding),
            ) {
                routes.forEach { route ->
                    RoutesCard(route, onItemClick)
                }
            }
        }
    )

}


@ExperimentalMaterialApi
@Composable
fun RoutesCard(route: Space, onItemClick: (Space) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp, 16.dp, 0.dp)
            .clickable { },
        onClick = { onItemClick(route) },
        backgroundColor = MaterialTheme.colorScheme.surfaceVariant

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = route.name,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(24.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(24.dp),
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null
            )
        }
    }

}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewConversation() {
    AppTheme {
        Routes(listOf(Space("prueba", ""), Space("prueba1", ""), Space("prueba 2", ""), Space("prueba1", "")))
    }
}
