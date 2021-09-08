package com.easycruise.navigation_compose_practice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.easycruise.navigation_compose_practice.screens.ChatScreen
import com.easycruise.navigation_compose_practice.screens.details_screen.DetailScreen
import com.easycruise.navigation_compose_practice.screens.home_screen.HomeScreen
import com.easycruise.navigation_compose_practice.screens.settings_screen.SettingsScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.ChatScreen.route) {
            ChatScreen()
        }
        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen()
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}", // /{name}/{age}       ?name={name} - optional       /{name} - mandatory
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Borko"
                }
            )
        ) { entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}