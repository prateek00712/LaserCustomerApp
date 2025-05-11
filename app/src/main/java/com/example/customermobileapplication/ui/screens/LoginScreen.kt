package com.example.customermobileapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
import com.example.customermobileapplication.PreferencesManager
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes

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
                )
            ), // Pastel Peach background
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
                    .height(100.dp),// Adjust height as needed

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
                textStyle = TextStyle(
                    color = AppColors.TextPrimary,
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp
                ),
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
                textStyle = TextStyle(
                    color = AppColors.TextPrimary,
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp
                ),
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
                    .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
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

@Composable
fun LoginScreen2(navController: NavHostController) {

    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)
    var phoneNumber by remember { mutableStateOf("") }

    val poppinsBoldFontFamily = FontFamily(
        Font(R.font.poppins_semi_bold) // Make sure the font file is in the `res/font` folder
    )
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular) // Make sure the font file is in the `res/font` folder
    )
    // Background Image
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_login_background_img), // replace with your image
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Foreground: Glass Effect Card
        Box(
            modifier = Modifier
//                .fillMaxWidth(0.85f)
                .fillMaxWidth()
                .align(Alignment.Center)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.15f),
                            Color.White.copy(alpha = 0.05f)
                        )
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
//                .blur(16.dp) // Background blur
                .padding(24.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login to The\n\nPureSkyn Experience\n\n(At Comfort of your Home)",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontFamily = poppinsBoldFontFamily,
                    textAlign = TextAlign.Center
                )
                /*Text(
                    text = "UNCOVER Experience",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontFamily = poppinsBoldFontFamily,

                    )*/
                Spacer(modifier = Modifier.height(8.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Phone Number",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    PhoneNumberField(
                        phoneNumber = phoneNumber,
                        onPhoneNumberChange = { phoneNumber = it }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {

                        if (phoneNumber.length == 10) {
                            preferencesManager.savePhoneNumber(phoneNumber)
                            navController.navigate(Routes.OTP_SCREEN)
                        } else {
                            Toast.makeText(
                                context,
                                "Enter valid 10 digit phone number",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.NewButtonColor2
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = "Get OTP",
                        color = Color.Black,
                        fontFamily = poppinsFontFamily,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Composable
fun PhoneNumberField(
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit
) {
    val poppinsBoldFontFamily = FontFamily(
        Font(R.font.poppins_semi_bold)
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = "+91 |",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = phoneNumber,
                onValueChange = { if (it.length <= 10) onPhoneNumberChange(it) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = poppinsBoldFontFamily
                ),
                modifier = Modifier.weight(1f)
            )
        }

        Divider(
            color = Color.White.copy(alpha = 0.5f),
            thickness = 1.dp,
            modifier = Modifier.padding(start = 48.dp)
        )
    }
}
