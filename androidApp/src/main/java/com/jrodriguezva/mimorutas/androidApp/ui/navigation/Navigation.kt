package com.jrodriguezva.mimorutas.androidApp.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jrodriguezva.mimorutas.androidApp.ui.Routes
import com.jrodriguezva.mimorutas.androidApp.ui.login.Login
import com.jrodriguezva.mimorutas.androidApp.ui.login.Register
import com.jrodriguezva.mimorutas.androidApp.ui.routes.MainDetailLayout
import com.jrodriguezva.mimorutas.shared.RouteService
import com.jrodriguezva.mimorutas.shared.models.Space

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")

    object Detail : Screen("detail/{${NavArgs.ItemId.key}}?${NavArgs.Title.key}={${NavArgs.Title.key}}") {
        fun createRoute(route: Space) = "detail/${route.args}?${NavArgs.Title.key}=${route.name}"
    }
}

enum class NavArgs(val key: String) {
    ItemId("itemId"),
    Title("title"),
}

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) { backStackEntry ->
            Login(onLoggedIn = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(backStackEntry.destination.id) {
                        inclusive = true
                    }
                }
            },
                onClickSignUp = {
                    navController.navigate(Screen.Register.route) {
                        popUpTo(backStackEntry.destination.id) {
                            inclusive = false
                        }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            Routes(
                routes = RouteService.getAllSpaces(),
                onItemClick = {
                    navController.navigate(Screen.Detail.createRoute(it))
                })
        }

        composable(Screen.Register.route) {
            Register(
                onSignIn = {
                    navController.navigate(Screen.Home.route)
                },
                onBackPressed = { navController.popBackStack() }
            )
        }

        composable(
            Screen.Detail.route,
            arguments = listOf(navArgument(NavArgs.Title.key) { defaultValue = "" })
        ) {
            MainDetailLayout(
                onBackPressed = { navController.popBackStack() }
            )
        }
    }
}
