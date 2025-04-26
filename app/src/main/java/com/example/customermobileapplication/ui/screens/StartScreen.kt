package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes


@Composable
fun StartScreen(navController: NavController){

    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular) // Make sure the font file is in the `res/font` folder
    )
    val poppinsBoldFontFamily = FontFamily(
        Font(R.font.poppins_semi_bold) // Make sure the font file is in the `res/font` folder
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(

                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE6A88E), // Pastel peach
                        Color(0xFFF6D9CB), // Lighter complementary color

                    )
                )), // Pastel Peach background
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_login_img), // Replace with your image resource
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Ensure the image fills the box, cropping if necessary
        )

//        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
//            Text(
//                text = "Pure Skyn",
//                color = Color.White,
//                fontFamily = poppinsBoldFontFamily,
//                fontSize = 24.sp,
//                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
//            )

            Image(
                painter = painterResource(id = R.drawable.login_logo), // Replace with your image resource
                contentDescription = "Welcome Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .alpha(0.9f)
                    .height(150.dp) // Adjust height as needed
            )
            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                    .background(
                        color = Color(0xFFF6D9CB).copy(alpha = 0.8f), // Pastel pink with 50% opacity (faded effect)
                        shape = RoundedCornerShape(8.dp) // Optional: Rounded corners for the background
                    )
                    .padding(16.dp) // Padding to give some space around the text
            ) {
                Text(
                    text = "Your Way to Silky, Smooth & Hair Free-Skin",
                    color = AppColors.Primary,
                    fontFamily = poppinsBoldFontFamily,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                )
            }

            // Image at the top


            // Buttons at the bottom
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(
                    onClick = { navController.navigate(Routes.LOGIN_SCREEN)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFEE6503)), // Button color
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 6.dp, // Elevation for the shadow
                        pressedElevation = 8.dp // Elevation when pressed
                    ),
                    shape = RoundedCornerShape(8.dp) // Less rounded corners
                ) {
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate(Routes.SIGNUP_SCREEN)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFEE6503)), // Button color
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 6.dp, // Elevation for the shadow
                        pressedElevation = 8.dp // Elevation when pressed
                    ),
                    shape = RoundedCornerShape(8.dp) // Less rounded corners
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                        .background(
                            color = Color(0xFFF6D9CB).copy(alpha = 0.8f), // Pastel pink with 50% opacity (faded effect)
                            shape = RoundedCornerShape(8.dp) // Optional: Rounded corners for the background
                        )
                        .padding(16.dp) // Padding to give some space around the text
                ) {
                    Text(
                        text = "By using this application, you agree to the Terms and Conditions outlined herein. Please read them carefully before proceeding.",
                        color = Color(0xFFEE6503),
                        fontFamily = poppinsFontFamily,
                        fontSize = 12.sp,
//                        modifier = Modifier.padding(
//                            top = 8.dp,
//                            bottom = 8.dp,
//                            start = 16.dp,
//                            end = 16.dp
//                        )
                    )
                }
            }
        }
    }
}