package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
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


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
// Image at the top
            Image(
                painter = painterResource(id = R.drawable.login_logo), // Replace with your image resource
                contentDescription = "Welcome Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
                    .height(100.dp) ,// Adjust height as needed

            )

            // Header
            Text(
                text = "Login",
                fontSize = 32.sp,
                modifier = Modifier.padding(bottom = 32.dp),
                textAlign = TextAlign.Center,
                fontFamily = poppinsBoldFontFamily,
                color = AppColors.TextPrimary

            )

            // Email ID Text
            Text(
                text = "Email ID",
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                fontFamily = poppinsFontFamily,
                color = AppColors.TextPrimary
            )

// Email ID Text Field
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                            .background(Color.Transparent, shape = RoundedCornerShape(12.dp)),
                        textStyle = TextStyle(color = AppColors.TextPrimary, fontFamily = poppinsFontFamily, fontSize = 14.sp),
                        placeholder = {
                            Text(
                                "Enter your email",
                                fontFamily = poppinsFontFamily,
                                color = AppColors.TextPrimary,
                                fontSize = 14.sp
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        shape = RoundedCornerShape(12.dp), // Curve the edges of the OutlinedTextField

                    )

            // Password Text
            Text(
                text = "Password",
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                fontFamily = poppinsFontFamily,
                color = AppColors.TextPrimary
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                    .background(Color.Transparent, shape = RoundedCornerShape(14.dp)),
                textStyle = TextStyle(color = AppColors.TextPrimary, fontFamily = poppinsFontFamily, fontSize = 14.sp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                placeholder = {
                    Text(
                        "Enter your password",
                        fontFamily = poppinsFontFamily,
                        color = AppColors.TextPrimary,
                        fontSize = 14.sp
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                shape = RoundedCornerShape(12.dp), // Curve the edges of the OutlinedTextField

            )

            // Forgot Password Text
            ClickableText(
                text = androidx.compose.ui.text.AnnotatedString("Forgot Password?"),
                onClick = { /* Handle Forgot Password Action */ },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 16.dp,start =16.dp,end = 16.dp),
                style = TextStyle(
                    fontFamily = poppinsFontFamily,
                    color = Color(0xFFEE6503),
                    textDecoration = TextDecoration.Underline
                )
            )

            // Login Button
            Button(
                onClick = { /* Handle Sign Up action */ },
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
                Text(text = "Login", fontSize = 16.sp, color = AppColors.Background)
            }
        }
    }
}
