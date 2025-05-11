package com.example.customermobileapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.customermobileapplication.ui.screens.BookingScreen
import com.example.customermobileapplication.ui.screens.DermafracScreen
import com.example.customermobileapplication.ui.screens.HomeScreen
import com.example.customermobileapplication.ui.screens.LaserHairRemovalScreenMen
import com.example.customermobileapplication.ui.screens.LaserHairRemovalScreenWomen
import com.example.customermobileapplication.ui.screens.LaserHariRemovalPackageScreen
import com.example.customermobileapplication.ui.screens.LoginScreen
import com.example.customermobileapplication.ui.screens.LoginScreen2
import com.example.customermobileapplication.ui.screens.MediFacialPackageScreen
import com.example.customermobileapplication.ui.screens.OtpScreen
import com.example.customermobileapplication.ui.screens.OxyGeneoFacial
import com.example.customermobileapplication.ui.screens.OxyHydraFacial
import com.example.customermobileapplication.ui.screens.ProductsScreen
import com.example.customermobileapplication.ui.screens.ProfileScreen
import com.example.customermobileapplication.ui.screens.RegisterScreen
import com.example.customermobileapplication.ui.screens.RfSkinTightScreen
import com.example.customermobileapplication.ui.screens.ServiceScreen
//import com.example.customermobileapplication.ui.screens.SignUpScreen
import com.example.customermobileapplication.ui.screens.SplashScreen
import com.example.customermobileapplication.ui.screens.StartScreen
import com.example.customermobileapplication.ui.screens.StaticProductDetailScreenPreviewFaceWash
import com.example.customermobileapplication.ui.screens.StaticProductDetailScreenPreviewMoisturizer
import com.example.customermobileapplication.ui.screens.StaticProductDetailScreenPreviewOxidant
import com.example.customermobileapplication.ui.screens.StaticProductDetailScreenPreviewPigmentation
import com.example.customermobileapplication.ui.screens.StaticProductDetailScreenPreviewSerum
import com.example.customermobileapplication.ui.screens.StaticProductDetailScreenPreviewSunscreen
import com.example.customermobileapplication.ui.screens.TreatmentPlanScreen

@Composable
fun AppNavigationGraph(navController: NavHostController, modifier: Modifier = Modifier){

//    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SPLASH_SCREEN,modifier = modifier) {

        composable(Routes.SPLASH_SCREEN){
            SplashScreen(navController)
        }
        composable(Routes.START_SCREEN){
            StartScreen(navController)
        }
        composable(Routes.LOGIN_SCREEN){
            LoginScreen2(navController)
        }
        composable(Routes.OTP_SCREEN){
            OtpScreen(navController)
        }
        composable(Routes.SIGNUP_SCREEN){
//            SignUpScreen(navController)
            RegisterScreen(navController)
        }
        composable(Routes.HOME_SCREEN){
            HomeScreen(navController)
        }
        composable(Routes.PROFILE_SCREEN){
            ProfileScreen()
        }
        composable(Routes.BOOKING_SCREEN){
            BookingScreen()
        }
        composable(Routes.SERVICE_SCREEN){
            ServiceScreen(navController)
        }
        composable(Routes.TREATMENT_PLAN_SCREEN){
            TreatmentPlanScreen(navController)
        }
        composable(Routes.LASER_HAIR_PACKAGE_SCREEN){
            LaserHariRemovalPackageScreen(navController)
        }
        composable(Routes.MEDI_FACIAL_PACKAGE_SCREEN){
            MediFacialPackageScreen(navController)
        }
        composable(Routes.PRODUCTS_SCREEN){
            ProductsScreen(navController)
        }
        composable(Routes.LASER_HAIR_WOMEN){
            LaserHairRemovalScreenWomen(navController)
        }
        composable(Routes.LASER_HAIR_MEN){
            LaserHairRemovalScreenMen(navController)
        }
        composable(Routes.OXYHYDRA_FACIAL){
            OxyHydraFacial(navController)
        }
        composable(Routes.OXYGENEO){
            OxyGeneoFacial(navController)
        }
        composable(Routes.RF_SKIN_TIGHT){
            RfSkinTightScreen(navController)
        }
        composable(Routes.DERMAFRAC){
            DermafracScreen(navController)
        }
        composable(Routes.PRODUCT_DETAIL_SERUM){
            StaticProductDetailScreenPreviewSerum()
        }
        composable(Routes.PRODUCT_DETAIL_WASH){
            StaticProductDetailScreenPreviewFaceWash()
        }
        composable(Routes.PRODUCT_DETAIL_MOISTURIZER){
            StaticProductDetailScreenPreviewMoisturizer()
        }
        composable(Routes.PRODUCT_DETAIL_PIGMENTATION){
            StaticProductDetailScreenPreviewPigmentation()
        }
        composable(Routes.PRODUCT_DETAIL_ANTIOXIDANT){
            StaticProductDetailScreenPreviewOxidant()
        }
        composable(Routes.PRODUCT_DETAIL_SUNSCREEN){
            StaticProductDetailScreenPreviewSunscreen()
        }

    }
}