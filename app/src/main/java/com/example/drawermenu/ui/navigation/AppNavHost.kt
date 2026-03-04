package com.example.drawermenu.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.drawermenu.ui.layout.MainScaffold
import com.example.drawermenu.ui.screens.AboutScreen
import com.example.drawermenu.ui.screens.HomeScreen
import com.example.drawermenu.ui.screens.SettingsScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    MainScaffold(navController) {
        NavHost(navController = navController, startDestination = Destination.Home) {
            composable<Destination.Home> { HomeScreen() }
            composable<Destination.Settings> { SettingsScreen() }
            composable<Destination.About> { AboutScreen() }
        }
    }
}