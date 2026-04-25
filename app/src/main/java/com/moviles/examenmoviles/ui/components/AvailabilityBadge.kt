package com.moviles.examenmoviles.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AvailabilityBadge(
    isAvailable: Boolean,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isAvailable) Color(0xFFE6F4EA) else Color(0xFFFFEBEE)
    val textColor = if (isAvailable) Color(0xFF2E7D32) else Color(0xFFC62828)
    val label = if (isAvailable) "Available" else "Unavailable"

    Text(
        text = label,
        color = textColor,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(50.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}