package com.example.drawermenu.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.drawermenu.ui.navigation.Destination

@Composable
fun DrawerMenu(currentRoute: String?, onNavigate: (Destination) -> Unit) {
    ModalDrawerSheet { //panell de fons sobre el qual es dibuixa el menú lateral (contenidor).
        Spacer(Modifier.height(16.dp))
        Text(text = "Menú", modifier = Modifier.padding(16.dp))

        DrawerItem.entries.forEach { item ->
            val selected = currentRoute == item.route.toString()
            NavigationDrawerItem(
            icon = {Icon(imageVector = item.icon, contentDescription = item.text)},
            label = { Text(text = item.text) },
            selected = selected,
            onClick = { onNavigate(item.route) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}