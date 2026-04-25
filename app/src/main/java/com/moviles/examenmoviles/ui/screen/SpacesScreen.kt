package com.moviles.examenmoviles.ui.screens.spaces

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.CoworkingSpace
import com.moviles.examenmoviles.ui.components.CoworkingSpaceCard
import com.moviles.examenmoviles.ui.theme.AppBackground
import com.moviles.examenmoviles.ui.theme.AppNavUnselected
import com.moviles.examenmoviles.ui.theme.AppPrimary

private val mockSpaces = listOf(
    CoworkingSpace(id = 1, name = "Sky Lounge", location = "Floor 3, Building A", pricePerHour = 20.0, capacity = 8, isAvailable = true),
    CoworkingSpace(id = 2, name = "The Bunker", location = "Floor 1, Building B", pricePerHour = 15.0, capacity = 12, isAvailable = false),
    CoworkingSpace(id = 3, name = "Garden Room", location = "Floor 2, Building A", pricePerHour = 18.0, capacity = 6, isAvailable = true),
    CoworkingSpace(id = 4, name = "Focus Pod", location = "Floor 4, Building C", pricePerHour = 10.0, capacity = 2, isAvailable = true),
    CoworkingSpace(id = 5, name = "Board Room", location = "Floor 5, Building A", pricePerHour = 35.0, capacity = 20, isAvailable = false)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpacesScreen(
    onSpaceClick: (CoworkingSpace) -> Unit,
    modifier: Modifier = Modifier,
    spaces: List<CoworkingSpace> = mockSpaces
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Coworking Spaces",
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        bottomBar = {
            SpacesBottomBar()
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                start = 14.dp,
                end = 14.dp,
                top = 12.dp,
                bottom = 96.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(spaces) { space ->
                CoworkingSpaceCard(
                    space = space,
                    onClick = { onSpaceClick(space) }
                )
            }
        }
    }
}

@Composable
private fun SpacesBottomBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "Home") },
            colors = spacesNavItemColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.CalendarToday,
                    contentDescription = "Reservations"
                )
            },
            label = { Text(text = "Reservations") },
            colors = spacesNavItemColors()
        )

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
            colors = spacesNavItemColors()
        )
    }
}

@Composable
private fun spacesNavItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = AppPrimary,
    selectedTextColor = AppPrimary,
    unselectedIconColor = AppNavUnselected,
    unselectedTextColor = AppNavUnselected,
    indicatorColor = AppBackground
)