package com.moviles.examenmoviles.ui.screens.spaces

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.CoworkingSpace
import com.moviles.examenmoviles.ui.components.AppBottomBar
import com.moviles.examenmoviles.ui.components.AppButton
import com.moviles.examenmoviles.ui.components.AvailabilityBadge
import com.moviles.examenmoviles.ui.components.SpaceDetailInfoRow
import com.moviles.examenmoviles.ui.theme.AppBackground
import com.moviles.examenmoviles.ui.theme.AppNavUnselected
import com.moviles.examenmoviles.ui.theme.AppPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceDetailScreen(
    space: CoworkingSpace,
    onBackClick: () -> Unit,
    onReserveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Space Detail",
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = "Back",
                            tint = AppPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        bottomBar = {
            AppBottomBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            SpaceDetailHeader(space = space)
            SpaceDetailInfo(space = space)
            Spacer(modifier = Modifier.weight(1f))
            AppButton(
                text = "Reserve Space",
                onClick = onReserveClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun SpaceDetailHeader(
    space: CoworkingSpace
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = space.name,
            style = MaterialTheme.typography.headlineLarge
        )
        AvailabilityBadge(isAvailable = space.isAvailable)
    }
}

@Composable
private fun SpaceDetailInfo(
    space: CoworkingSpace
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SpaceDetailInfoRow(
            icon = Icons.Outlined.LocationOn,
            label = "Location",
            value = space.location
        )
        SpaceDetailInfoRow(
            icon = Icons.Outlined.People,
            label = "Capacity",
            value = "${space.capacity} people"
        )
        SpaceDetailInfoRow(
            icon = Icons.Outlined.AttachMoney,
            label = "Price",
            value = "$${space.pricePerHour}/hr"
        )
    }
}

@Preview
@Composable
fun SpaceDetailScreenPreview() {
    SpaceDetailScreen(
        space = CoworkingSpace(
            id = 1,
            name = "Sky Lounge",
            location = "Nose ",
            pricePerHour = 20.0,
            capacity = 8,
            isAvailable = true
        ),
        onBackClick = {},
        onReserveClick = {}
        )
}