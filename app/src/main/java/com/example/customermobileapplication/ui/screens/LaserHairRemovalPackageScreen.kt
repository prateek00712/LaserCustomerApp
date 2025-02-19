package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel

@Composable
fun LaserHariRemovalPackageScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val womenPackages: List<Triple<String, String, String>> = listOf(
        Triple("Full Body - (4+1) Session", "₹60000", "Book Now"),
        Triple("Full Body - Single Session", "₹15000", "Book Now"),
        Triple("Face and Neck - (4+1) Session", "₹20000", "Book Now"),
        Triple("Face and Neck - Single Session", "₹5000", "Book Now"),
        Triple("Bikini and Buttocks - (4+1) Session", "₹24000", "Book Now"),
        Triple("Bikini and Buttocks - Single Session", "₹6000", "Book Now"),
        Triple("Arms and Underarms - (4+1) Session", "₹26000", "Book Now"),
        Triple("Arms and Underarms - Single Session", "₹6500", "Book Now"),
        Triple("Chest and Back - (4+1) Session", "₹32000", "Book Now"),
        Triple("Chest and Back - Single Session", "₹8000", "Book Now"),
        Triple("Half Legs - Single Session", "₹5000", "Book Now"),
        Triple("Full Legs - Single Session", "₹8000", "Book Now"),
        Triple("Back - Single Session", "₹5000", "Book Now"),
        Triple("Chest - Single Session", "₹5000", "Book Now"),
        Triple("Bikini - Single Session", "₹5000", "Book Now")
    )

    val menPackages: List<Triple<String, String, String>> = listOf(
        Triple("Full Body - (4+1) Session", "₹60000", "Book Now"),
        Triple("Full Body - Single Session", "₹15000", "Book Now"),
        Triple("Face and Neck - (4+1) Session", "₹20000", "Book Now"),
        Triple("Face and Neck - Single Session", "₹5000", "Book Now"),
        Triple("Arms and Underarms - (4+1) Session", "₹26000", "Book Now"),
        Triple("Arms and Underarms - Single Session", "₹6500", "Book Now"),
        Triple("Chest and Back - (4+1) Session", "₹32000", "Book Now"),
        Triple("Chest and Back - Single Session", "₹8000", "Book Now"),
        Triple("Half Legs - Single Session", "₹5000", "Book Now"),
        Triple("Full Legs - Single Session", "₹8000", "Book Now"),
        Triple("Back - Single Session", "₹5000", "Book Now"),
        Triple("Chest - Single Session", "₹5000", "Book Now")
    )
    val tabTitles = listOf("Men", "Women")
    var selectedTabIndex = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
//                AppColors.PastelPeach,
                Color.White,
                shape = RoundedCornerShape(8.dp)
            ) // Pastel Peach background
            .padding(16.dp)
    ) {
        Text(
            text = "Book Your Package Today!!",
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 24.sp,
            color = AppColors.TextPrimary,
            modifier = Modifier.padding(bottom = 2.dp),
        )
        Box(
            modifier = Modifier
                .height(2.dp) // Line height
                .width(200.dp) // Line width
                .background(AppColors.TextPrimary) // Orange color
        )
        Text(
            text = "Laser Hair Removal",
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            fontSize = 20.sp,
            color = AppColors.Primary,
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))
        Column(modifier = Modifier.fillMaxSize()) {
            // Tab Row
            TabRow(

                selectedTabIndex = selectedTabIndex.value,
                modifier = Modifier.fillMaxWidth(),
                containerColor = Color.White,
                contentColor = AppColors.PastelColor,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value]),
                        color = AppColors.Primary, // ✅ Set custom indicator color
                        height = 4.dp
                    )}
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex.value == index,
                        onClick = { selectedTabIndex.value = index },
                        text = { Text(title, fontFamily = FontFamily(Font(R.font.poppins_medium)),color = if (selectedTabIndex.value == index) AppColors.Primary else Color.Black ) },
                    )
                }
            }

            // Tab Content
            when (selectedTabIndex.value) {
                0 -> PackageList(womenPackages)  // Women Packages
                1 -> PackageList(menPackages)    // Men Packages
            }
        }

    }
}


@Composable
fun PackageList(packages: List<Triple<String, String, String>>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(2.dp)
    ) {
        // Table Header
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppColors.TextPrimary, shape = RoundedCornerShape(8.dp))
                    .padding(vertical = 12.dp, horizontal = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Treatment",
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.weight(1.5f)
                )
                Text(
                    text = "Price",
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Action",
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }

        // Package List
        items(packages) { packageItem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .background(Color.White),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = packageItem.first,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1.5f)
                )
                Text(
                    text = packageItem.second,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = { /* TODO: Handle booking action */ },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.Primary)
                ) {
                    Text(
                        text = packageItem.third,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 10.sp,
                        color = Color.White
                    )
                }
            }
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}