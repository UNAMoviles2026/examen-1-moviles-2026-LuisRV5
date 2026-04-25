package com.moviles.examenmoviles.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.moviles.examenmoviles.ui.theme.AppBackground
import com.moviles.examenmoviles.ui.theme.AppNavUnselected
import com.moviles.examenmoviles.ui.theme.AppPrimary

@Composable
fun AppBottomBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        NavigationBarItemHome()
        NavigationBarItemCalendar()
        NavigationBarItemProfile()
    }
}

@Composable
private fun RowScope.NavigationBarItemHome() {
    NavigationBarItem(
        selected = true,
        onClick = { },
        icon = {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home"
            )
        },
        label = { Text(text = "Home") },
        colors = navigationBarItemColors()
    )
}

@Composable
private fun RowScope.NavigationBarItemCalendar() {
    NavigationBarItem(
        selected = false,
        onClick = { },
        icon = {
            Icon(
                imageVector = Icons.Outlined.CalendarToday,
                contentDescription = "Calendar"
            )
        },
        label = { Text(text = "Calendar") },
        colors = navigationBarItemColors()
    )
}

@Composable
private fun RowScope.NavigationBarItemProfile() {
    NavigationBarItem(
        selected = false,
        onClick = { },
        icon = {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Profile"
            )
        },
        label = { Text(text = "Profile") },
        colors = navigationBarItemColors()
    )
}

@Composable
private fun navigationBarItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = AppPrimary,
    selectedTextColor = AppPrimary,
    unselectedIconColor = AppNavUnselected,
    unselectedTextColor = AppNavUnselected,
    indicatorColor = AppBackground
)
