package com.bibin.babu.software.developer.core.presentation.designsystem

import android.app.Activity
import android.view.WindowInsets.Side
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import kotlinx.coroutines.flow.flowOf

val DarkColorScheme = darkColorScheme(
    primary = RuntrackRed,
    background = RuntrackBlack,
    surface = RuntrackDarkGray,
    secondary = RuntrackWhite,
    tertiary = RuntrackWhite,
    primaryContainer = RuntrackRed30,
    onPrimary = RuntrackBlack,
    onBackground = RuntrackWhite,
    onSurface = RuntrackWhite,
    onSurfaceVariant = RuntrackGray,
    error = RuntrackRed
)

@Composable
fun RunTrackTheme(content: @Composable () -> Unit) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }
    MaterialTheme(colorScheme=colorScheme, typography = Typography,content=content)
}