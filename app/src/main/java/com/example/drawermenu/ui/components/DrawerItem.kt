package com.example.drawermenu.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.drawermenu.ui.navigation.Destination

enum class DrawerItem(
    val icon: ImageVector,
    val text: String,
    val route: Destination
) {
    HOME(Icons.Default.Home, "Home", Destination.Home),
    SETTINGS(Icons.Default.Settings, "Settings", Destination.Settings),
    ABOUT(Icons.Default.Info, "About", Destination.About),
}