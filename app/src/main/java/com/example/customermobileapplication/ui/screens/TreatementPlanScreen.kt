package com.example.customermobileapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel
import com.example.customermobileapplication.ui.viewmodel.ServiceViewModel

@Composable
fun TreatmentPlanScreen(
    navController: NavController,
    serviceViewModel: ServiceViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
//                AppColors.PastelPeach,
                Color.White,
//                shape = RoundedCornerShape(8.dp)
            ) // Pastel Peach background
            .padding(16.dp)
    ) {
        Text(
            text = "Prime Packages",
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(2.dp)
//                .verticalScroll(rememberScrollState())
        ) {
            //Package 1
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(AppColors.PastelColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            text = "Full Body Laser Hair Reduction - Female (6 sessions)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = AppColors.NewTextColor,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),

                            )
                        Spacer(modifier = Modifier.height(8.dp))

                        Image(
                            painter = painterResource(id = R.drawable.home_laser_skin_removal), // Replace with your image
//                        painter = painterResource(id = R.drawable.laser_hair_removal_packages), // Replace with your image
                            contentDescription = null,
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Price & Duration Row
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "₹50,000",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = AppColors.TextPrimary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "₹64,000",
                                fontSize = 14.sp,
                                color = Color.Gray,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            /*Icon(
                                Icons.Default.AccessTime,
                                contentDescription = "Duration",
                                tint = Color.Gray
                            )*/
                            Text(
                                text = "60 mins",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Features List
                        Column {
                            FeatureItem("Say goodbye to painful waxing and shaving forever!")
                            FeatureItem("Covers full body, including arms, legs, underarms, and bikini line.")
                            FeatureItem("Long-lasting smooth skin with advanced laser technology.")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Image & Button Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Button(
                                onClick = {
                                    serviceViewModel.savePackageToCart(
                                        "Laser Hair Reduction - Female",
                                        "Full Body",
                                        "6 Session",
                                        "Service",
                                        "50000",
                                        context
                                    )
                                },
                                colors = ButtonDefaults.buttonColors(AppColors.NewButtonColor),
                                modifier = Modifier
                                    .height(45.dp)
                                    .clip(RoundedCornerShape(12.dp))
                            ) {
                                Text(
                                    text = "Add To Cart",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            //Package 2
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(AppColors.PastelColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            text = "Full Body Laser Hair Reduction - Male (6 sessions)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = AppColors.NewTextColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Image(
                            painter = painterResource(id = R.drawable.home_laser_skin_men), // Replace with your image
//                        painter = painterResource(id = R.drawable.laser_hair_removal_packages), // Replace with your image
                            contentDescription = null,
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Price & Duration Row
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "₹50,000",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = AppColors.TextPrimary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "₹64,000",
                                fontSize = 14.sp,
                                color = Color.Gray,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            /*Icon(
                                Icons.Default.AccessTime,
                                contentDescription = "Duration",
                                tint = Color.Gray
                            )*/
                            Text(
                                text = " 60 mins",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Features List
                        Column {
                            FeatureItem("Say goodbye to painful waxing and shaving forever!")
                            FeatureItem("Covers full body, including chest, back, arms, legs, and underarms.")
                            FeatureItem("Long-lasting smooth skin with advanced laser technology.")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Image & Button Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Button(
                                onClick = { serviceViewModel.savePackageToCart(
                                    "Laser Hair Reduction - Male",
                                    "Full Body",
                                    "6 Session",
                                    "Service",
                                    "50000",
                                    context
                                )},
                                colors = ButtonDefaults.buttonColors(AppColors.NewButtonColor),
                                modifier = Modifier
                                    .height(45.dp)
                                    .clip(RoundedCornerShape(12.dp))
                            ) {
                                Text(
                                    text = "Add To Cart",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            //Package 3
            item{
                Card(
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(AppColors.PastelColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            text = "Oxy Hydra Facial + Oxygeneo Therapy",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = AppColors.NewTextColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Image(
                            painter = painterResource(id = R.drawable.custom_package_hydra_geneo), // Replace with your image
//                        painter = painterResource(id = R.drawable.laser_hair_removal_packages), // Replace with your image
                            contentDescription = null,
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Price & Duration Row
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "₹10,000",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = AppColors.TextPrimary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "₹15,000",
                                fontSize = 14.sp,
                                color = Color.Gray,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = " 60 mins",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Features List
                        Column {
                            FeatureItem("Deeply cleanses, hydrates, and rejuvenates your skin for a radiant glow.")
                            FeatureItem("Combines exfoliation, oxygenation, and nourishment for maximum skin benefits.")
                            FeatureItem("Reduces fine lines, evens skin tone, and enhances collagen production.")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Image & Button Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Button(
                                onClick = {serviceViewModel.savePackageToCart(
                                    "Oxy Hydra Facial + Oxygeneo Therapy",
                                    "Face",
                                    "1 Session",
                                    "Service",
                                    "10000",
                                    context
                                ) },
                                colors = ButtonDefaults.buttonColors(AppColors.NewButtonColor),
                                modifier = Modifier
                                    .height(45.dp)
                                    .clip(RoundedCornerShape(12.dp))
                            ) {
                                Text(
                                    text = "Add To Cart",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            //Package 4
            item{
                Card(
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(AppColors.PastelColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            text = "Oxy Hydra Facial + Oxygeno + Dermafrac",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = AppColors.NewTextColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Image(
                            painter = painterResource(id = R.drawable.custome_package_geneo_derma_hydra), // Replace with your image
//                        painter = painterResource(id = R.drawable.laser_hair_removal_packages), // Replace with your image
                            contentDescription = null,
                            modifier = Modifier
                                .height(160.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Price & Duration Row
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "₹15,000",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = AppColors.TextPrimary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "₹20,000",
                                fontSize = 14.sp,
                                color = Color.Gray,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = " 60 mins",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Features List
                        Column {
                            FeatureItem("A powerful 3-in-1 treatment for deep cleansing, hydration, and skin rejuvenation.")
                            FeatureItem("Combines oxygenation, micro-needling, and serum infusion for enhanced skin repair.")
                            FeatureItem("Reduces fine lines, improves skin texture, and boosts collagen production.")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Image & Button Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Button(
                                onClick = { serviceViewModel.savePackageToCart(
                                    "Oxy Hydra Facial + Oxygeno + Dermafrac",
                                    "Face",
                                    "1 Session",
                                    "Service",
                                    "15000",
                                    context
                                ) },
                                colors = ButtonDefaults.buttonColors(AppColors.NewButtonColor),
                                modifier = Modifier
                                    .height(45.dp)
                                    .clip(RoundedCornerShape(12.dp))
                            ) {
                                Text(
                                    text = "Add To Cart",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            //Package 5
            item{
                Card(
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(AppColors.PastelColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            text = "Oxygeneo + Dermafrac",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = AppColors.NewTextColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Image(
                            painter = painterResource(id = R.drawable.custom_image_geneo_derma), // Replace with your image
                            contentDescription = null,
                            modifier = Modifier
                                .height(160.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Price & Duration Row
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "₹10,000",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = AppColors.TextPrimary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "₹15,000",
                                fontSize = 14.sp,
                                color = Color.Gray,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = " 60 mins",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Features List
                        Column {
                            FeatureItem("Combines deep oxygenation with micro-needling for ultimate skin rejuvenation.")
                            FeatureItem("Enhances collagen production, reduces fine lines, and improves skin texture.")
                            FeatureItem("Infuses skin with essential nutrients for a radiant and youthful glow.")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Image & Button Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Button(
                                onClick = {serviceViewModel.savePackageToCart(
                                    "Oxygeneo + Dermafrac",
                                    "Face",
                                    "1 Session",
                                    "Service",
                                    "10000",
                                    context
                                )},
                                colors = ButtonDefaults.buttonColors(AppColors.NewButtonColor),
                                modifier = Modifier
                                    .height(45.dp)
                                    .clip(RoundedCornerShape(12.dp))
                            ) {
                                Text(
                                    text = "Add To Cart",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            //Package 6
            item{
                Card(
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(AppColors.PastelColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            text = "Oxy Hydra Facial + Dermafrac",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = AppColors.NewTextColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Image(
                            painter = painterResource(id = R.drawable.custom_package_hydra_derma), // Replace with your image
                            contentDescription = null,
                            modifier = Modifier
                                .height(160.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Price & Duration Row
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "₹10,000",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = AppColors.TextPrimary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "₹15,000",
                                fontSize = 14.sp,
                                color = Color.Gray,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = " 60 mins",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Features List
                        Column {
                            FeatureItem("Deeply hydrates and nourishes the skin for a refreshed, dewy glow.")
                            FeatureItem("Combines exfoliation with micro-needling to enhance skin rejuvenation.")
                            FeatureItem("Helps reduce fine lines, pigmentation, and uneven skin texture.")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Image & Button Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Button(
                                onClick = { serviceViewModel.savePackageToCart(
                                    "Oxy Hydra Facial + Dermafra",
                                    "Face",
                                    "1 Session",
                                    "Service",
                                    "10000",
                                    context
                                ) },
                                colors = ButtonDefaults.buttonColors(AppColors.NewButtonColor),
                                modifier = Modifier
                                    .height(45.dp)
                                    .clip(RoundedCornerShape(12.dp))
                            ) {
                                Text(
                                    text = "Add To Cart",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FeatureItem(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "Check",
            tint = Color(0xFF4CAF50),
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 14.sp, color = Color(0xFF4E4E4E))
    }
}