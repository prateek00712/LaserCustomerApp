package com.example.customermobileapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes

@Composable
fun DrawerContent(navController: NavController, onItemSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(
                color = AppColors.TextPrimary,
                shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)
            )
            .padding(top = 54.dp, bottom = 32.dp, start = 16.dp, end = 16.dp) // Increased top padding
    ) {
        // Header Row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(bottom = 32.dp) // Increased spacing below the header
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_logo), // Replace with your image
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(48.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp)) // Space between the image and text
            Text(
                text = "Pure Skyn",
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 20.sp,
                color = AppColors.Primary
            )

        }


        Text(
            text = "Menu",
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 24.dp), // More space below "Menu" title
            color = AppColors.Primary
        )

        // Drawer Items List
        val drawerItems = listOf(
            "Home" to Routes.HOME_SCREEN,
            "Your Orders" to Routes.ORDER_SCREEN,
            "About Us" to Routes.ABOUT_SCREEN,
            "Contact Us" to Routes.CONTACT_SCREEN,
            "Refer Now" to Routes.REFER_SCREEN,
            "Check For Update" to Routes.UPDATE_SCREEN,
            "Log Out" to Routes.SPLASH_SCREEN
        )

        // Drawer Items
        drawerItems.forEach { (title, route) ->
            Text(
                text = title,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemSelected(title) // Optional callback for additional actions
                        navController.navigate(route) // Navigate to the selected route
                    }
                    .padding(vertical = 16.dp),
                color = AppColors.Primary
            )
        }
    }
}

