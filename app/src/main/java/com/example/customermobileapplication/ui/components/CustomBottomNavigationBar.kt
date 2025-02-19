package com.example.customermobileapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.AppEntryPoint
import com.example.customermobileapplication.R
import com.example.customermobileapplication.getCurrentRoute
import com.example.customermobileapplication.ui.navigation.Routes


@Composable
fun CustomBottomNavigationBar(navController: NavController) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 8.dp, // Add shadow
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp) // Curve corners
            )
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)) // Clip to rounded corners
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE6A88E), // Pastel peach
                        Color(0xFFF6D9CB)  // Lighter complementary color
                    )
                ),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp) // Apply rounded shape
            )
    ) {
        BottomAppBar(
            containerColor = Color.Transparent, // Ensure BottomAppBar is transparent
            tonalElevation = 0.dp
        ) {
            // Home Navigation Item
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home), // Replace with your icon resource
                        contentDescription = "Home",
                        tint = AppColors.Primary,
                        modifier = Modifier.size(24.dp) // Ensure uniform icon size
                    )
                },
                label = { Text("Home", color = Color.Black) },
                selected = getCurrentRoute(navController) == Routes.HOME_SCREEN,
                onClick = { navController.navigate(Routes.HOME_SCREEN) }
            )

            // Plans Navigation Item
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_plans), // Replace with your icon resource
                        contentDescription = "Services",
                        tint = AppColors.Primary,
                        modifier = Modifier.size(24.dp) // Ensure uniform icon size
                    )
                },
                label = { Text("Packages", color = Color.Black, textAlign = TextAlign.Center) },
                selected = getCurrentRoute(navController) == Routes.TREATMENT_PLAN_SCREEN,
                onClick = { navController.navigate(Routes.TREATMENT_PLAN_SCREEN) }
            )

            // Cart Navigation Item
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_service_2), // Replace with your icon resource
                        contentDescription = "Services",
                        tint = AppColors.Primary,
                        modifier = Modifier.size(24.dp) // Ensure uniform icon size
                    )
                },
                label = { Text("Services", color = Color.Black) },
                selected = getCurrentRoute(navController) == Routes.SERVICE_SCREEN,
                onClick = { navController.navigate(Routes.SERVICE_SCREEN) }
            )

            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_product_2), // Replace with your icon resource
                        contentDescription = "Products",
                        tint = AppColors.Primary,
                        modifier = Modifier.size(24.dp) // Ensure uniform icon size
                    )
                },
                label = { Text("Products", color = Color.Black) },
                selected = getCurrentRoute(navController) == Routes.PRODUCTS_SCREEN,
                onClick = { navController.navigate(Routes.PRODUCTS_SCREEN) }
            )


            // Profile Navigation Item
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile), // Replace with your icon resource
                        contentDescription = "Profile",
                        tint = AppColors.Primary,
                        modifier = Modifier.size(24.dp) // Ensure uniform icon size
                    )
                },
                label = { Text("Profile", color = Color.Black) },
                selected = getCurrentRoute(navController) == Routes.PROFILE_SCREEN,
                onClick = { navController.navigate(Routes.PROFILE_SCREEN) }
            )
        }
    }

}


