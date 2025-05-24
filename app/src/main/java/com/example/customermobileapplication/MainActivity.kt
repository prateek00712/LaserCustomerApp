package com.example.customermobileapplication

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.customermobileapplication.ui.components.CustomBottomNavigationBar
import com.example.customermobileapplication.ui.components.CustomTopAppBar
import com.example.customermobileapplication.ui.components.DrawerContent
import com.example.customermobileapplication.ui.navigation.AppNavigationGraph
import com.example.customermobileapplication.ui.theme.CustomerMobileApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.customermobileapplication.ui.navigation.Routes
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomerMobileApplicationTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppEntryPoint()
                }
//                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppEntryPoint() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)
    val loginStatus = remember {
        mutableStateOf(preferencesManager.getLoginStatus())
    }

    val homeViewModel: HomeViewModel = hiltViewModel()
    val customerCount by homeViewModel.cartCount

    // Refresh count when AppEntryPoint starts
    LaunchedEffect(Unit) {
        homeViewModel.refreshCustomerCount()
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                navController,
                onItemSelected = { item ->
                    // Handle drawer item selection
                scope.launch { drawerState.close() }
                }
            )
        },
        gesturesEnabled = false,
        content = {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    val currentRoute = getCurrentRoute(navController)
                    if (currentRoute != Routes.SPLASH_SCREEN && currentRoute != Routes.LOGIN_SCREEN && currentRoute != Routes.SIGNUP_SCREEN &&
                        currentRoute != Routes.START_SCREEN && currentRoute!=Routes.OTP_SCREEN
                    ) {
                        CustomTopAppBar(
                            onMenuClick = {
                                scope.launch { drawerState.open() }
                            },
                            onCartClick = {
                                navController.navigate(Routes.BOOKING_SCREEN)
                            },
                            cartCount = customerCount // ✅ Pass count to app bar
                        )
                    }
                },
                bottomBar = {
                    val currentRoute = getCurrentRoute(navController)
                    if (currentRoute != Routes.SPLASH_SCREEN && currentRoute != Routes.LOGIN_SCREEN && currentRoute != Routes.SIGNUP_SCREEN &&
                        currentRoute != Routes.START_SCREEN && currentRoute!= Routes.OTP_SCREEN && currentRoute != Routes.PRODUCT_DETAIL_WASH
                        && currentRoute != Routes.PRODUCT_DETAIL_SERUM && currentRoute != Routes.PRODUCT_DETAIL_SUNSCREEN
                        && currentRoute != Routes.PRODUCT_DETAIL_MOISTURIZER && currentRoute != Routes.PRODUCT_DETAIL_PIGMENTATION
                        && currentRoute != Routes.PRODUCT_DETAIL_ANTIOXIDANT
                    ) {
                        CustomBottomNavigationBar(navController)
                    }
                }
            ) { innerPadding ->
                AppNavigationGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        })

}

@Composable
fun getCurrentRoute(navController: NavController): String? {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    return currentBackStackEntry?.destination?.route
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomerMobileApplicationTheme {
        Greeting("Android")
    }
}*/
