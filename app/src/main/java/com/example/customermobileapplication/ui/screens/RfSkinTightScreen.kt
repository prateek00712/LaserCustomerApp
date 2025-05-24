package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.viewmodel.ServiceViewModel

@Composable
fun DermafracScreen(navController: NavController, serviceViewModel: ServiceViewModel = hiltViewModel()) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var selectedPackageIndex by remember { mutableIntStateOf(0) }
    var dialogTitle by remember { mutableStateOf("") }
    var dialogSubtitle by remember { mutableStateOf("") }
    var dialogPackages by remember { mutableStateOf(emptyList<Pair<String, String>>()) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .padding(horizontal = 16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Derma Infusion Facial At Home",
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                fontSize = 20.sp,
                color = AppColors.NewTextColor
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            val image = painterResource(id = R.drawable.ic_dermafrac_skin_img)
            ServiceCard2(
                title = "Derma Infusion Facial",
                image = image,
                price = "₹10,000",
                time = "60 mins",
                descriptionList = listOf(
                    "Uses micro-needling infusion to deliver active serums deep into the skin.",
                    "Reduces fine lines, acne scars, and pigmentation for smoother skin."
                ),
                onAddToCart = { dialogTitle = "Oxy Hydra Facial at Home"
                    dialogSubtitle = "Select Your Package"
                    dialogPackages = listOf(
                        "Derma Infusion Facial – (4+1) Session" to "₹40,000",
                        "Derma Infusion Facial – Single Session" to "₹10,000"
                    )
                    selectedPackageIndex = 0
                    showDialog = true  }
            )
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
                    "Derma Infusion Facial",
                    if (selectedPackageIndex == 0) "5 Session" else "1 session",
                    "Service",
                    if (selectedPackageIndex == 0) "40000" else "10000",
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
}