package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.PreferencesManager
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel
import com.example.customermobileapplication.ui.viewmodel.ServiceViewModel

@Composable
fun LaserHairRemovalScreenMen(
    navController: NavController,
    serviceViewModel: ServiceViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var selectedPackageIndex by remember { mutableIntStateOf(0) }
    var dialogTitle by remember { mutableStateOf("") }
    var dialogSubtitle by remember { mutableStateOf("") }
    var dialogPackages by remember { mutableStateOf(emptyList<Pair<String, String>>()) }
    var showDialog1 by remember { mutableStateOf(false) }
    var showDialog2 by remember { mutableStateOf(false) }
    var showDialog3 by remember { mutableStateOf(false) }
    var showDialog4 by remember { mutableStateOf(false) }
    var showDialog5 by remember { mutableStateOf(false) }
    var showDialog6 by remember { mutableStateOf(false) }
    var showDialog7 by remember { mutableStateOf(false) }



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .padding(horizontal = 16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Laser Hair Removal Men At Home",
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                fontSize = 20.sp,
                color = AppColors.NewTextColor
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            Text(
                text = "Note: Please select either Full Body packages or Other Packages. You can't club Full Body Package with Other Packages.",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontSize = 12.sp,
                color = AppColors.Secondary,
                modifier = Modifier.padding(end = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            val image = painterResource(id = R.drawable.ic_man_full_body_img)
            ServiceCard2(
                title = "Full Body",
                image = image,
                price = "₹15,000",
                time = "60 mins",
                descriptionList = listOf(
                    "No more painful waxing or frequent shaving hassles.",
                    "Covers full body, including arms, legs and underarms"
                ),
                onAddToCart = {
                    dialogTitle = "Laser Hair Removal Men at Home"
                    dialogSubtitle = "Select Your Package"
                    dialogPackages = listOf(
                        "Full Body – (4+1) Session" to "₹60,000",
                        "Full Body – Single Session" to "₹15,000"
                    )
                    selectedPackageIndex = 0
                    showDialog = true
                }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image2 = painterResource(id = R.drawable.ic_face_neck_img)
            ServiceCard2(
                title = "Face & Neck",
                image = image2,
                price = "₹5,000",
                time = "60 mins",
                descriptionList = listOf(
                    "Say goodbye to unwanted facial and neck hair with long-lasting results.",
                    "Gentle and effective treatment for smooth, hair-free skin."
                ),
                onAddToCart = { dialogTitle = "Laser Hair Removal Men at Home"
                    dialogSubtitle = "Select Your Package"
                    dialogPackages = listOf(
                        "Face & Neck – (4+1) Session" to "₹20,000",
                        "Face & Neck – Single Session" to "₹5,000"
                    )
                    selectedPackageIndex = 0
                    showDialog1 = true })
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image4 = painterResource(id = R.drawable.ic_men_chest_back_img)
            ServiceCard2(
                title = "Chest & Back",
                price = "₹8,500",
                time = "60 mins",
                image = image4,
                descriptionList = listOf(
                    "Get a clean, groomed look with long-lasting hair reduction.",
                    "Say goodbye to painful waxing and frequent shaving."
                ),
                onAddToCart = { dialogTitle = "Laser Hair Removal Men at Home"
                    dialogSubtitle = "Select Your Package"
                    dialogPackages = listOf(
                        "Chest & Back – (4+1) Session" to "₹32,000",
                        "Chest & Back – Single Session" to "₹8,500"
                    )
                    selectedPackageIndex = 0
                    showDialog2 = true }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image5 = painterResource(id = R.drawable.ic_arms_under_img)
            ServiceCard2(
                title = "Arms & Underarms",
                price = "₹6,500",
                time = "60 mins",
                image = image5,
                descriptionList = listOf(
                    "Enjoy silky-smooth skin with long-lasting hair reduction.",
                    "Quick, safe, and effective treatment for flawless underarms and arms."
                ),
                onAddToCart = { dialogTitle = "Laser Hair Removal Men at Home"
                    dialogSubtitle = "Select Your Package"
                    dialogPackages = listOf(
                        "Arms & Underarms – (4+1) Session" to "₹26,000",
                        "Arms & Underarms – Single Session" to "₹6,500"
                    )
                    selectedPackageIndex = 0
                    showDialog3 = true }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image6 = painterResource(id = R.drawable.ic_full_legs_img)
            ServiceCard2(
                title = "Full Legs",
                price = "₹8,000",
                time = "60 mins",
                image = image6,
                descriptionList = listOf(
                    "Enjoy silky smooth legs with a long-lasting hair-free look.",
                    "Say goodbye to frequent shaving and painful waxing."
                ),
                onAddToCart = { dialogTitle = "Laser Hair Removal Men at Home"
                    dialogSubtitle = "Select Your Package"
                    dialogPackages = listOf(
                        "Full Legs – (4+1) Session" to "₹32,000",
                        "Full Legs – Single Session" to "₹8,000"
                    )
                    selectedPackageIndex = 0
                    showDialog4 = true }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image7 = painterResource(id = R.drawable.ic_half_legs_img)
            ServiceCard2(
                title = "Half Legs",
                price = "₹5,000",
                time = "60 mins",
                image = image7,
                descriptionList = listOf(
                    "Smooth, hair-free legs with long-lasting results.",
                    "No more razor burns or painful waxing sessions."
                ),
                onAddToCart = { dialogTitle = "Laser Hair Removal Men at Home"
                    dialogSubtitle = "Select Your Package"
                    dialogPackages = listOf(
                        "Half Legs – (4+1) Session" to "₹20,000",
                        "Half Legs – Single Session" to "₹5,000"
                    )
                    selectedPackageIndex = 0
                    showDialog5 = true }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image8 = painterResource(id = R.drawable.ic_full_back_img)
            ServiceCard2(
                title = "Back",
                price = "₹5,000",
                time = "60 mins",
                image = image8,
                descriptionList = listOf(
                    "Achieve a smooth, hair-free back with long-lasting results.",
                    "No more painful waxing or constant shaving."
                ),
                onAddToCart = { dialogTitle = "Laser Hair Removal Men at Home"
                    dialogSubtitle = "Select Your Package"
                    dialogPackages = listOf(
                        "Back – (4+1) Session" to "₹20,000",
                        "Back – Single Session" to "₹5,000"
                    )
                    selectedPackageIndex = 0
                    showDialog6 = true  }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image9 = painterResource(id = R.drawable.ic_men_chest_back_img)
            ServiceCard2(
                title = "Chest",
                price = "₹5,000",
                time = "60 mins",
                image = image9,
                descriptionList = listOf(
                    "Get a hair-free chest with advanced laser technology for smooth skin.",
                    "Say goodbye to frequent waxing and shaving hassles."
                ),
                onAddToCart = { dialogTitle = "Laser Hair Removal Men at Home"
                    dialogSubtitle = "Select Your Package"
                    dialogPackages = listOf(
                        "Chest – (4+1) Session" to "₹20,000",
                        "Chest – Single Session" to "₹5,000"
                    )
                    selectedPackageIndex = 0
                    showDialog7 = true}
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }

    if (showDialog) {
        PackageSelectionDialog(
            title = dialogTitle,
            subtitle = dialogSubtitle,
            packages = dialogPackages,
            selectedIndex = selectedPackageIndex,
            onSelect = { selectedPackageIndex = it },
            onAddToCart = {
                serviceViewModel.savePackageToCart(
                    dialogTitle,
                    "Full Body Men",
                    if (selectedPackageIndex == 0) "5 Session" else "1 session",
                    "Service",
                    if (selectedPackageIndex == 0) "60000" else "15000",
                    context
                )
                showDialog = false
            },
            onBack = { showDialog = false },
            onDismiss = {
                showDialog = false
            }
        )
    }

    if (showDialog1) {
        PackageSelectionDialog(
            title = dialogTitle,
            subtitle = dialogSubtitle,
            packages = dialogPackages,
            selectedIndex = selectedPackageIndex,
            onSelect = { selectedPackageIndex = it },
            onAddToCart = {
                serviceViewModel.savePackageToCart(
                    dialogTitle,
                    "Face & Neck",
                    if (selectedPackageIndex == 0) "5 Session" else "1 session",
                    "Service",
                    if (selectedPackageIndex == 0) "20000" else "5000",
                    context
                )
                showDialog1 = false
            },
            onBack = { showDialog1 = false },
            onDismiss = {
                showDialog1 = false
            }
        )
    }

    if (showDialog2) {
        PackageSelectionDialog(
            title = dialogTitle,
            subtitle = dialogSubtitle,
            packages = dialogPackages,
            selectedIndex = selectedPackageIndex,
            onSelect = { selectedPackageIndex = it },
            onAddToCart = {
                serviceViewModel.savePackageToCart(
                    dialogTitle,
                    "Chest & Back",
                    if (selectedPackageIndex == 0) "5 Session" else "1 session",
                    "Service",
                    if (selectedPackageIndex == 0) "32000" else "8500",
                    context
                )
                showDialog2 = false
            },
            onBack = { showDialog2 = false },
            onDismiss = {
                showDialog2 = false
            }
        )
    }

    if (showDialog3) {
        PackageSelectionDialog(
            title = dialogTitle,
            subtitle = dialogSubtitle,
            packages = dialogPackages,
            selectedIndex = selectedPackageIndex,
            onSelect = { selectedPackageIndex = it },
            onAddToCart = {
                serviceViewModel.savePackageToCart(
                    dialogTitle,
                    "Arms & Underarms",
                    if (selectedPackageIndex == 0) "5 Session" else "1 session",
                    "Service",
                    if (selectedPackageIndex == 0) "26000" else "6500",
                    context
                )
                showDialog3 = false
            },
            onBack = { showDialog3 = false },
            onDismiss = {
                showDialog3 = false
            }
        )
    }

    if (showDialog4) {
        PackageSelectionDialog(
            title = dialogTitle,
            subtitle = dialogSubtitle,
            packages = dialogPackages,
            selectedIndex = selectedPackageIndex,
            onSelect = { selectedPackageIndex = it },
            onAddToCart = {
                serviceViewModel.savePackageToCart(
                    dialogTitle,
                    "Full Legs",
                    if (selectedPackageIndex == 0) "5 Session" else "1 session",
                    "Service",
                    if (selectedPackageIndex == 0) "32000" else "8000",
                    context
                )
                showDialog4 = false
            },
            onBack = { showDialog4 = false },
            onDismiss = {
                showDialog4 = false
            }
        )
    }

    if (showDialog5) {
        PackageSelectionDialog(
            title = dialogTitle,
            subtitle = dialogSubtitle,
            packages = dialogPackages,
            selectedIndex = selectedPackageIndex,
            onSelect = { selectedPackageIndex = it },
            onAddToCart = {
                serviceViewModel.savePackageToCart(
                    dialogTitle,
                    "Half Legs",
                    if (selectedPackageIndex == 0) "5 Session" else "1 session",
                    "Service",
                    if (selectedPackageIndex == 0) "20000" else "5000",
                    context
                )
                showDialog5 = false
            },
            onBack = { showDialog5 = false },
            onDismiss = {
                showDialog5 = false
            }
        )
    }

    if (showDialog6) {
        PackageSelectionDialog(
            title = dialogTitle,
            subtitle = dialogSubtitle,
            packages = dialogPackages,
            selectedIndex = selectedPackageIndex,
            onSelect = { selectedPackageIndex = it },
            onAddToCart = {
                serviceViewModel.savePackageToCart(
                    dialogTitle,
                    "Back",
                    if (selectedPackageIndex == 0) "5 Session" else "1 session",
                    "Service",
                    if (selectedPackageIndex == 0) "20000" else "5000",
                    context
                )
                showDialog6 = false
            },
            onBack = { showDialog6 = false },
            onDismiss = {
                showDialog6 = false
            }
        )
    }

    if (showDialog7) {
        PackageSelectionDialog(
            title = dialogTitle,
            subtitle = dialogSubtitle,
            packages = dialogPackages,
            selectedIndex = selectedPackageIndex,
            onSelect = { selectedPackageIndex = it },
            onAddToCart = {
                serviceViewModel.savePackageToCart(
                    dialogTitle,
                    "Chest",
                    if (selectedPackageIndex == 0) "5 Session" else "1 session",
                    "Service",
                    if (selectedPackageIndex == 0) "20000" else "5000",
                    context
                )
                showDialog7 = false
            },
            onBack = { showDialog7 = false },
            onDismiss = {
                showDialog7 = false
            }
        )
    }
}