package com.example.customermobileapplication

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object AppColors {
    val Primary = Color(0xFFEE6503) // Peach color
    val Secondary = Color(0xFF007B83) // Example: Teal
    val Background = Color(0xFFF5F5F5) // Example: Light gray
    val TextPrimary = Color(0xFF333333) // Example: Dark gray
    val PastelPeach = Color(0xFFFFE5D9)
    val PastelColor = Color(0xFFFFF7E9)
    val TextSecondary = Color(0xFF757575) // Example: Medium gray
    val NewButtonColor = Color(0xFFAF8062)
    val NewTextColor = Color(0xFF6B4F3F)
    val NewButtonColor2 = Color(0xFFF8F5EF)
    val LightBrown = Color(0xFFB87E54)
    val Beige = Color(0xFFE4C6A5)
    val GradientColor = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFF7E9), // Pastel peach
            Color(0xFFF8F5EF)  // Lighter complementary color
        )
    )
}