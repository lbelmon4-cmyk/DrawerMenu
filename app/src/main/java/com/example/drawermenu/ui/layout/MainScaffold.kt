package com.example.drawermenu.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.wear.compose.navigation.currentBackStackEntryAsState
import com.example.drawermenu.ui.components.DrawerMenu
import com.example.drawermenu.ui.navigation.Destination
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(navController: NavController, content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    //Recorda quin és l'estat del menú lateral (si està Open o Closed).
    val scope = rememberCoroutineScope()
    //Obre i tanca el menú lateral implica una animació, i en Compose les animacions requereixen una "corutina" (un procés que s'executa en segon pla).
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    //Observa el navController per saber en quina pantalla ens trobem exactament en aquest moment

    ModalNavigationDrawer(//component que ens permet crear un menú lateral
    drawerState = drawerState,
    drawerContent = { //indica que hi ha d'haver dins del menú
        DrawerMenu(
        currentRoute = currentRoute,
        onNavigate = { destination ->
            navController.navigate(destination) {
                popUpTo(Destination.Home) { inclusive = false } //esborra l'historial de pantalles
                launchSingleTop = true
            }
            scope.launch { drawerState.close() } //després d'anar a la pantalla tanca el menú
        }
        )
    }
    ) {
        Scaffold(topBar = {
            TopAppBar(title = { Text("Mi App") },
            navigationIcon = {
                IconButton(onClick = { scope.launch { drawerState.open() } }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menú")
                }
            }
            )
        }) { padding ->
            Box(Modifier.padding(padding)) { content() }
        }
    }
}