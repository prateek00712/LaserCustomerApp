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
fun OxyHydraFacial(navController: NavController,
                   serviceViewModel: ServiceViewModel = hiltViewModel()) {
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
                text = "Oxyhydra Facial At Home",
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                fontSize = 20.sp,
                color = AppColors.NewTextColor
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            val image = painterResource(id = R.drawable.ic_oxy_hydra_facial_icon_img)
            ServiceCard2(
                title = "Oxy Hydra Facial",
                image = image,
                price = "₹5,000",
                time = "60 mins",
                descriptionList = listOf(
                    " Deeply cleanses, hydrates, and rejuvenates your skin in one session.",
                    "Removes dead skin cells and impurities while boosting hydration."
                ),
                onAddToCart = { dialogTitle = "Oxy Hydra Facial at Home"
                    dialogSubtitle = "Select Your Package"
                    dialogPackages = listOf(
                        "Oxy Hydra Facial – (4+1) Session" to "₹20,000",
                        "Oxy Hydra Facial – Single Session" to "₹5,000"
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
                    "Oxy Hydra Facial",
                    if (selectedPackageIndex == 0) "5 Session" else "1 session",
                    "Service",
                    if (selectedPackageIndex == 0) "20000" else "5000",
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