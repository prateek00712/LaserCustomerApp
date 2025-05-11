package com.example.customermobileapplication.ui.screens

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.customermobileapplication.PreferencesManager
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes

@Composable
fun SplashScreen(navController: NavController) {

    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)

    LaunchedEffect(key1 = true) {
        kotlinx.coroutines.delay(2000) // Delay for 2 seconds
        if (!preferencesManager.getLoginStatus()) {
            navController.navigate(Routes.LOGIN_SCREEN) {
                popUpTo(Routes.SPLASH_SCREEN) { inclusive = true }
            }
        }
        else{
            navController.navigate(Routes.HOME_SCREEN) {
                popUpTo(Routes.SPLASH_SCREEN) { inclusive = true }
            }
        }
    }

    val bounceAnim = rememberInfiniteTransition(label = "")
    val scale by bounceAnim.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 700, easing = EaseInOutCubic),
            repeatMode = RepeatMode.Reverse
        ), label = "Bouncing effect"
    )

    // Splash screen UI
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE6A88E), // Pastel peach
                        Color(0xFFF6D9CB), // Lighter complementary color

                    )
                )),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.pure_skyn),
            contentDescription = "Splash Logo",
            modifier = Modifier
                .size(150.dp) // Adjust size as needed
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
        )
    }
}

//@Composable
//fun SplashScreen(navController: NavController) {
//    // Use LaunchedEffect to handle navigation after a delay
//    LaunchedEffect(key1 = true) {
//        kotlinx.coroutines.delay(2000) // Delay for 2 seconds
//        navController.navigate(Routes.HOME_SCREEN) {
//            popUpTo(Routes.SPLASH_SCREEN) { inclusive = true }
//        }
//    }
//
//
//    // Splash screen UI
//    val bounceAnim = rememberInfiniteTransition(label = "")
//    val scale by bounceAnim.animateFloat(
//        initialValue = 0.8f,
//        targetValue = 1.2f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 700, easing = EaseInOutCubic),
//            repeatMode = RepeatMode.Reverse
//        ), label = "Bouncing effect"
//    )
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFE5B4)), // Pastel peach background
//        contentAlignment = Alignment.Center
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.logo1), // Replace with your image resource
//            contentDescription = "Splash Logo",
//            modifier = Modifier
//                .size(150.dp) // Adjust size as needed
//                .graphicsLayer {
//                    scaleX = scale
//                    scaleY = scale
//                }
//        )
//    }
//}