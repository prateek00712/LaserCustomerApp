package com.example.customermobileapplication

import android.os.Bundle
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
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
        content = {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    val currentRoute = getCurrentRoute(navController)
                    if (currentRoute != Routes.SPLASH_SCREEN && currentRoute != Routes.LOGIN_SCREEN && currentRoute != Routes.SIGNUP_SCREEN &&
                        currentRoute != Routes.START_SCREEN
                    ) {
                        CustomTopAppBar(
                            onMenuClick = {
                                scope.launch { drawerState.open() }
                            },
                            onCartClick = {
                                navController.navigate(Routes.BOOKING_SCREEN)
                            }
                        )
                            /*title = {
                                Text(
                                    text = "Pure Skyn",
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    color = AppColors.TextPrimary
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Open Drawer",
                                        tint = AppColors.TextPrimary
                                    )
                                }
                            })*/
                    }
                },
                bottomBar = {
                    val currentRoute = getCurrentRoute(navController)
                    if (currentRoute != Routes.SPLASH_SCREEN && currentRoute != Routes.LOGIN_SCREEN && currentRoute != Routes.SIGNUP_SCREEN &&
                        currentRoute != Routes.START_SCREEN
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
