package com.moviles.examenmoviles.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.ui.theme.AppIconTint
import com.moviles.examenmoviles.ui.theme.AppSecondaryText

@Composable
fun SpaceDetailInfoRow(
    icon: ImageVector,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = AppIconTint
        )
        Text(
            text = "$label: $value",
            color = AppSecondaryText,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun SpaceDetailInfoRowPreview() {
    SpaceDetailInfoRow(
        icon = androidx.compose.material.icons.Icons.Outlined.Home,
        label = "Location",
        value = "Floor 3, Building A"
    )
}