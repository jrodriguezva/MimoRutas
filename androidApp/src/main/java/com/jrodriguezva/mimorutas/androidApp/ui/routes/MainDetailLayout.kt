package com.jrodriguezva.mimorutas.androidApp.ui.routes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class Screens(val route: String, val label: String, val icon: ImageVector? = null) {
    object HomeScreen : Screens("Home", "Home", Icons.Default.LocationOn)
    object FavoritesScreen : Screens("Favorites", "Favorites", Icons.Default.Favorite)
}

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun MainDetailLayout(
    viewModel: MainDetailViewModel = viewModel(),
    onBackPressed: () -> Unit = {}
) {
    val bottomNavigationItems = listOf(Screens.HomeScreen, Screens.FavoritesScreen)

    val navController = rememberNavController()
    val bottomBar: @Composable () -> Unit = { BottomNavigation(navController, bottomNavigationItems) }

    NavHost(navController, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) {
            RoutesDetail(viewModel, bottomBar, onBackPressed)
        }
        composable(Screens.FavoritesScreen.route) {
            FavoritesScreen(bottomBar, viewModel, onBackPressed)
        }
    }

}


@Composable
private fun BottomNavigation(navController: NavHostController, items: List<Screens>) {

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route


        items.forEach { screen ->
            NavigationBarItem(
                icon = { screen.icon?.let { Icon(it, contentDescription = screen.label) } },
                label = {
                    Text(screen.label, color = MaterialTheme.colorScheme.onSurface)
                },
                selected = currentRoute == screen.route,
                alwaysShowLabel = false, // This hides the title for the unselected items
                onClick = {
                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}