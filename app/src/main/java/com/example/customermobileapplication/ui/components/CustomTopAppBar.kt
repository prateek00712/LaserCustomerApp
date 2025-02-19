package com.example.customermobileapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R


@Composable
fun CustomTopAppBar(
    onMenuClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFE6A88E), // Pastel peach
                        Color(0xFFF6D9CB)  // Lighter complementary color
                    )
                )
            )
            .height(72.dp)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Menu Icon
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = AppColors.TextPrimary// Adjust color as per design
                )
            }

            // Title
            Text(
                text = "Pure Skyn",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 20.sp,
                color = AppColors.TextPrimary
            )

            // Cart Icon
            IconButton(onClick = onCartClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_cart),
                    contentDescription = "Cart",
                    tint = AppColors.TextPrimary // Adjust color as per design
                )
            }
        }
    }
}
