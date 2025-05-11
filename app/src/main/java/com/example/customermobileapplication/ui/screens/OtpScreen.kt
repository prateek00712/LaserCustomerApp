package com.example.customermobileapplication.ui.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
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
import com.ozcanalasalvar.otp_view.compose.OtpView
import kotlinx.coroutines.delay

@Composable
fun OtpScreen(navController: NavHostController) {

    val poppinsBoldFontFamily = FontFamily(
        Font(R.font.poppins_semi_bold) // Make sure the font file is in the `res/font` folder
    )
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular) // Make sure the font file is in the `res/font` folder
    )
    var otpValue by remember { mutableStateOf("") }
    var isOtpCompleted by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)
    val numberValue by remember { mutableStateOf(preferencesManager.getPhoneNumber()) }

    var timer by remember { mutableStateOf(60) }
    var isTimerRunning by remember { mutableStateOf(true) }


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_otp_background_img), // your background image
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
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
//                .blur(16.dp)
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

                Spacer(modifier = Modifier.height(8.dp))

                // OTP info text
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "OTP Has Been Sent To ",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp,
                        fontFamily = poppinsBoldFontFamily
                    )
                    Text(
                        text = "+91 $numberValue",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        fontFamily = poppinsBoldFontFamily
                    )
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = Color.White,
                        modifier = Modifier
                            .size(18.dp)
                            .padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // OTP Input
                OtpView(
                    value = otpValue,
                    digits = 6,
                    textColor = Color.Black,
                    activeColor = AppColors.NewButtonColor2,
                    passiveColor = AppColors.NewButtonColor2,
                    fontSize = 22.sp,
                    fontFamily = poppinsBoldFontFamily,
                    onTextChange = { value, completed ->
                        otpValue = value
                        isOtpCompleted = completed

                        if (completed) {
                            // User entered full 6 digits
                            Log.d("OtpView", "Completed OTP: $value")
                            // 🔥 You can call your API to verify OTP here
                        }
                    }

                )

                Spacer(modifier = Modifier.height(8.dp))

                // Timer Text
                // Timer Text
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Didn't Receive OTP?",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    if (isTimerRunning) {
                        Text(
                            text = "${timer}s",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = poppinsBoldFontFamily,
                            fontWeight = FontWeight.Bold
                        )
                    } else {
                        Text(
                            text = "Resend",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = poppinsBoldFontFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {
                                // When user clicks "Resend", reset timer
                                timer = 60
                                isTimerRunning = true
                                // TODO: Call your resend OTP API here if needed
                            }
                        )
                    }
                }
                LaunchedEffect(key1 = isTimerRunning) {
                    if (isTimerRunning) {
                        while (timer > 0) {
                            delay(1000L)
                            timer--
                        }
                        isTimerRunning = false
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { navController.navigate(Routes.SIGNUP_SCREEN) },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.NewButtonColor2
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = "Login",
                        color = Color.Black,
                        fontFamily = poppinsFontFamily,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

