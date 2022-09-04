package com.example.mensfashion.core.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = YellowMain,
    primaryVariant = MainWhiteColor,
    secondary = GrayColor.copy(alpha = 0.3f),
    onSecondary = MainWhiteColor    
)

private val LightColorPalette = lightColors(
    primary = DarkBlue,
    primaryVariant = MainWhiteColor,
    secondary = GrayColor
)

@Composable
fun MenFashionTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (darkTheme) DarkBlue else MainWhiteColor
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}