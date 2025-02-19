package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel

@Composable
fun TreatmentPlanScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
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
            text = "Packages",
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 24.sp,
            color = AppColors.Primary,
            modifier = Modifier.padding(bottom = 2.dp),
        )
        Box(
            modifier = Modifier
                .height(2.dp) // Line height
                .width(200.dp) // Line width
                .background(AppColors.Primary) // Orange color
        )
        Text(
            text = "What We Offer!",
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(2.dp)
                .verticalScroll(rememberScrollState())
        ) {
            //Laser Hair Removal Packages
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .wrapContentHeight(),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(AppColors.TextPrimary)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Laser Hair Removal Packages",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.img_laser_package), // Replace with your image
//                        painter = painterResource(id = R.drawable.laser_hair_removal_packages), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                    Button(
                        onClick = { navController.navigate(Routes.LASER_HAIR_PACKAGE_SCREEN) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp), // Add padding to the sides
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = AppColors.Primary)
                    ) {
                        Text(
                            text = "Know More & Book Now",
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }
            }

            //Medi Facial Packages
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .wrapContentHeight(),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(AppColors.TextPrimary)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Medi Facial Packages",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
//                        painter = painterResource(id = R.drawable.medi_facial_packages), // Replace with your image
                        painter = painterResource(id = R.drawable.img_medi_facial_banner), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                    Button(
                        onClick = { navController.navigate(Routes.MEDI_FACIAL_PACKAGE_SCREEN) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp), // Add padding to the sides
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = AppColors.Primary)
                    ) {
                        Text(
                            text = "Know More & Book Now",
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
