package com.easycruise.navigation_compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.easycruise.navigation_compose_practice.navigation.BottomNavigationBar
import com.easycruise.navigation_compose_practice.navigation.Navigation
import com.easycruise.navigation_compose_practice.navigation.Screen
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp()
        }
    }
}

@Preview
@ExperimentalPagerApi
@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    Screen.HomeScreen,
                    Screen.ChatScreen,
                    Screen.SettingsScreen
                ),
                navController = navController,
                onItemClick = { bottomNavItem ->
                    navController.navigate(bottomNavItem.route) {
                        popUpTo(Screen.HomeScreen.route)
                        launchSingleTop = true
                    }
                }
            )
        }
    ) {
        Navigation(navController = navController)
    }
}






