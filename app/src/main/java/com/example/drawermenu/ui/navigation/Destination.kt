package com.example.drawermenu.ui.navigation
import kotlinx.serialization.Serializable

sealed class Destination() {
    @Serializable
    object Home : Destination()

    @Serializable
    object Settings : Destination()

    @Serializable
    object About : Destination()
}