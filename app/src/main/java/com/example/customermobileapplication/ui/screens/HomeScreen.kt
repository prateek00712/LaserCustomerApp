package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.navigation.Routes
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
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
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = "Hi, Prateek",
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 24.sp,
            color = AppColors.Primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        //Why PureSkyn
       /* Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_why_us), // Replace with your image
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Why Pure Skyn",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 16.sp,
                        color = AppColors.Primary
                    )
                    Text(
                        text = "1. Advance Diode Laser technology.\n2.Painless Laser Hair Removal.\n3. Medical-Grade Laser Hair Removal.\n4. Vastly Reduced Hair Growth.\n5. Trusted Technology.",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }*/
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.home_header), // Replace with your image
                contentDescription = null,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit
            )
            /*Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_why_us), // Replace with your image
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Why Pure Skyn",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 16.sp,
                        color = AppColors.Primary
                    )
                    Text(
                        text = "1. Advance Diode Laser technology.\n2.Painless Laser Hair Removal.\n3. Medical-Grade Laser Hair Removal.\n4. Vastly Reduced Hair Growth.\n5. Trusted Technology.",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                }
            }*/
        }
        //package about us
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(AppColors.PastelColor)
        ) {
            Spacer(Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "About Us",
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 18.sp,
                color = AppColors.Primary,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp),
                text = "At Pure Skyn we are focused on providing you with the permanent laser hair removal results that you have always wanted and nothing less. We stand behind our work and ensure that all of our customers are 100% satisfied. If you are looking for laser hair removal in India, please search \"laser hair removal near me\" to find our location and contact us to Book a FREE consultation.",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 15.sp,
                color = Color.Black,
                textAlign = TextAlign.Justify
            )
            Spacer(Modifier.height(16.dp))
        }
        // packages Cards
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(AppColors.PastelColor)
        ) {
            Spacer(Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Most Popular\nLaser Hair Removal",
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 18.sp,
                color = AppColors.Primary,
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.img_men_lsr), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "For Men",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center // Ensures text is centered
                    )
                }
//                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.img_women_lsr), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "For Women",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center // Ensures text is centered
                    )
                }
            }
            Button(
                onClick = { navController.navigate(Routes.TREATMENT_PLAN_SCREEN) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .padding(start = 24.dp, end = 24.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.Primary, // Orange color
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Explore Packages",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            }
            Spacer(Modifier.height(16.dp))
        }
        //services card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(AppColors.PastelColor)
        ) {
            Spacer(Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Services Offered",
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 18.sp,
                color = AppColors.Primary,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Start Your Skin Journey Today",
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                fontSize = 16.sp,
                color = AppColors.Primary,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(120.dp) // Fix width of each column to avoid distortion
                        .wrapContentHeight() // Ensure the column height wraps content
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home_laser_skin_removal), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Laser Hair Removal Women",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center // Ensures text is centered
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(120.dp) // Fix width of each column to avoid distortion
                        .wrapContentHeight() // Ensure the column height wraps content
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home_laser_skin_men), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Laser Hair Removal Men",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center // Ensures text is centered
                    )
                }

            }
            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(120.dp) // Fix width of each column to avoid distortion
                        .wrapContentHeight() // Ensure the column height wraps content
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home_rf_skin_tight), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "RF Skin Tightening",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center // Ensures text is centered
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(120.dp) // Fix width of each column to avoid distortion
                        .wrapContentHeight() // Ensure the column height wraps content
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home_dermafrac), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Dermafrac Infusion Facial",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center // Ensures text is centered
                    )
                }

            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(120.dp) // Fix width of each column to avoid distortion
                        .wrapContentHeight() // Ensure the column height wraps content
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home_oxygeneo), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp)) // Add spacing between image and text
                    Text(
                        text = "Oxygeneo",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center // Ensures text is centered
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(120.dp) // Fix width of each column to avoid distortion
                        .wrapContentHeight() // Ensure the column height wraps content
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home_oxy_hydra), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp)) // Add spacing between image and text
                    Text(
                        text = "Oxy Hydra Facial",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center // Ensures text is centered
                    )
                }
            }

            Button(
                onClick = { navController.navigate(Routes.SERVICE_SCREEN) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .padding(start = 24.dp, end = 24.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.Primary, // Orange color
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Explore Services",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            }
            Spacer(Modifier.height(16.dp))
        }


    }
}


/*

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}*/
