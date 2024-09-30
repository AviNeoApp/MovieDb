package com.example.moviedb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.moviedb.screens.detail.DetailScreen
import com.example.moviedb.screens.home.HomeScreen

@Composable
fun AppNavigation() {
    val controller = rememberNavController()
    NavHost(navController = controller, startDestination = Screens.Home) {
        composable<Screens.Home> {
            HomeScreen(
                controller = controller
            )
        }
        composable<Screens.Detail> {
            val screen = it.toRoute<Screens.Detail>()
            DetailScreen(
                onBackClick = {
                    controller.navigateUp()
                },
                screen.id
            )
        }
    }
}

