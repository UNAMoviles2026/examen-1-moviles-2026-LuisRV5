// AppNavHost.kt
package com.moviles.examenmoviles.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moviles.examenmoviles.data.CoworkingSpace
import com.moviles.examenmoviles.ui.screens.spaces.SpaceDetailScreen
import com.moviles.examenmoviles.ui.screens.spaces.SpacesScreen

private val mockSpaces = listOf(
    CoworkingSpace(id = 1, name = "Sky Lounge", location = "Floor 3, Building A", pricePerHour = 20.0, capacity = 8, isAvailable = true),
    CoworkingSpace(id = 2, name = "The Bunker", location = "Floor 1, Building B", pricePerHour = 15.0, capacity = 12, isAvailable = false),
    CoworkingSpace(id = 3, name = "Garden Room", location = "Floor 2, Building A", pricePerHour = 18.0, capacity = 6, isAvailable = true),
    CoworkingSpace(id = 4, name = "Focus Pod", location = "Floor 4, Building C", pricePerHour = 10.0, capacity = 2, isAvailable = true),
    CoworkingSpace(id = 5, name = "Board Room", location = "Floor 5, Building A", pricePerHour = 35.0, capacity = 20, isAvailable = false)
)

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestinations.SPACES,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = AppDestinations.SPACES) {
            SpacesScreen(
                onSpaceClick = { space ->
                    navController.navigate(AppDestinations.spaceDetail(space.id))
                }
            )
        }

        composable(route = AppDestinations.SPACE_DETAIL) { backStackEntry ->
            val spaceId = backStackEntry.arguments?.getString("spaceId")?.toIntOrNull()
            val space = mockSpaces.find { it.id == spaceId }

            space?.let {
                SpaceDetailScreen(
                    space = it,
                    onBackClick = { navController.popBackStack() },
                    onReserveClick = { navController.popBackStack() }
                )
            }
        }
    }
}