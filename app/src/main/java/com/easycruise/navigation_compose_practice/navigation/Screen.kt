package com.easycruise.navigation_compose_practice.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    var name: String,
    var route: String,
    var icon: ImageVector?,
) {
    object HomeScreen: Screen("Home", "home_screen", icon = Icons.Default.Home)
    object ChatScreen: Screen("Chat","chat_screen", icon = Icons.Default.Notifications)
    object SettingsScreen: Screen("Settings","settings_screen", icon = Icons.Default.Settings)
    object DetailScreen: Screen("Details","detail_screen", icon = null)

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

