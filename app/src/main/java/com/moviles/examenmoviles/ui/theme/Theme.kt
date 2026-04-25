package com.moviles.examenmoviles.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = AppPrimary,
    onPrimary = AppBackground,
    background = AppBackground,
    onBackground = AppPrimary,
    surface = AppSurface,
    onSurface = AppPrimary,
    surfaceVariant = AppSurfaceVariant,
    onSurfaceVariant = AppSecondaryText,
    outline = AppBorder,
    error = AppError
)

private val LightColorScheme = lightColorScheme(
    primary = AppPrimary,
    onPrimary = AppBackground,
    background = AppBackground,
    onBackground = AppPrimary,
    surface = AppSurface,
    onSurface = AppPrimary,
    surfaceVariant = AppSurfaceVariant,
    onSurfaceVariant = AppSecondaryText,
    outline = AppBorder,
    error = AppError
)


@Composable
fun ExamenMovilesTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}