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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
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


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()

) {
    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)

    //Servie List
    data class ServiceItem(val imageRes: Int, val title: String)

    val services = listOf(
        ServiceItem(R.drawable.home_laser_skin_removal, "Full Body Laser Hair Reduction - Female"),
        ServiceItem(R.drawable.home_laser_skin_men, "Full Body Laser Hair Reduction - Male"),
        ServiceItem(R.drawable.custom_package_hydra_geneo, "Oxy Hydra Facial + Oxygeneo Therapy"),
        ServiceItem(R.drawable.custome_package_geneo_derma_hydra, "Oxy Hydra Facial + Oxygeno + Dermafrac"),
        ServiceItem(R.drawable.custom_image_geneo_derma, "Oxygeneo + Dermafrac"),
        ServiceItem(R.drawable.custom_package_hydra_derma, "Oxy Hydra Facial + Dermafrac"),
        // Add more if needed
    )

    //Product List
    data class CategoryItem(
        val imageRes: Int,
        val title: String
    )

    val categories = listOf(
        CategoryItem(R.drawable.ic_sunscreen_img, "Sunscreens"),
        CategoryItem(R.drawable.ic_face_serum, "Face Serum"),
        CategoryItem(R.drawable.ic_face_wash_img, "Face Wash"),
        CategoryItem(R.drawable.ic_moisturizer_img, "Moisturizers"),
        CategoryItem(R.drawable.ic_pigemntation_img, "Pigementation Removal"),
        CategoryItem(R.drawable.ic_skin_antioxi_img, "Skin Antioxidants")

        // Add more as needed
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White,
//                shape = RoundedCornerShape(8.dp)
            ) // Pastel Peach background
            .padding(16.dp)
//            .verticalScroll(rememberScrollState()),
    ) {

        LazyColumn {

            item {
                Text(
                    text = "Hi, ${preferencesManager.getName()}",
                    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                    fontSize = 24.sp,
                    color = AppColors.Primary,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

            }
            //Pager
            item {
                SimplePagerWithImages2()
            }
            //original Laser service
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Our Services",
                    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                    fontSize = 24.sp,
                    color = AppColors.Primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ServiceCardCopy(imageRes = R.drawable.ic_laser_women_home_img_1,
                        title = "Laser Hair Removal Women",
                        onClick = {navController.navigate(Routes.LASER_HAIR_WOMEN)})

                    ServiceCardCopy(imageRes = R.drawable.ic_laser_men_home_img_1,
                        title = "Laser Hair Removal Men",
                        onClick = {navController.navigate(Routes.LASER_HAIR_MEN)})
                }
            }

            //original oxy facial and geneo
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ServiceCardCopy(imageRes = R.drawable.ic_oxy_home_img,
                        title = "Oxy Hydra Facial",
                        onClick = {navController.navigate(Routes.OXYHYDRA_FACIAL)})

                    ServiceCardCopy(imageRes = R.drawable.ic_oxygeneo_home_img,
                        title = "Oxygeneo",
                        onClick = {navController.navigate(Routes.OXYGENEO)})
                }
            }

            //original oxy facial and geneo
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ServiceCardCopy(imageRes = R.drawable.ic_rf_skin_home_img,
                        title = "RF Skin Tightening",
                        onClick = {navController.navigate(Routes.RF_SKIN_TIGHT)})

                    ServiceCardCopy(imageRes = R.drawable.ic_derma_home_img,
                        title = "Dermafrac Infusion Facial",
                        onClick = {navController.navigate(Routes.DERMAFRAC
                        )})
                }
                Spacer(modifier = Modifier.height(16.dp))
            }


            // Services Cards
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .wrapContentHeight(),
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(AppColors.PastelColor)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Most Loved Treatments",
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                            fontSize = 16.sp,
                            color = AppColors.Primary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp)) // Add space before the button

                        // Horizontal Scrollable Cards
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp) // Height similar to your cards
                        ) {
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(services) { service ->
                                    Card(
                                        modifier = Modifier
                                            .width(140.dp)
                                            .height(210.dp),
                                        shape = RoundedCornerShape(12.dp),
                                        elevation = CardDefaults.cardElevation(4.dp),
                                        colors = CardDefaults.cardColors(Color.White)
                                    ) {
                                        Box(
                                            modifier = Modifier.fillMaxSize()
                                        ) {
                                            // Image filling the entire card
                                            Image(
                                                painter = painterResource(id = service.imageRes),
                                                contentDescription = service.title,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier.fillMaxSize() // Image will fill the whole space
                                            )

                                            // Text at the bottom with translucent black background
                                            Box(
                                                modifier = Modifier
                                                    .align(Alignment.BottomCenter)
                                                    .fillMaxWidth()
                                                    .background(Color.Black.copy(alpha = 0.2f)) // Translucent black background
                                                    .padding(vertical = 8.dp)
                                            ) {
                                                Text(
                                                    text = service.title,
                                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                                    fontSize = 14.sp,
                                                    color = Color.White,
                                                    textAlign = TextAlign.Center,
                                                    modifier = Modifier.fillMaxWidth()
                                                )
                                            }
                                        }
                                    }
                                }

                            }
                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .background(
                                        brush = Brush.horizontalGradient(
                                            colors = listOf(Color.Transparent, Color.White),
                                            startX = 800f, // Start fade around this pixel
                                            endX = 1000f // End fade around this pixel
                                        )
                                    )
                            )
                        }
                        // Fading effect on the right

                        Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                        Button(
                            onClick = { navController.navigate(Routes.TREATMENT_PLAN_SCREEN) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp), // Add padding to the sides
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = AppColors.Primary)
                        ) {
                            Text(
                                text = "Explore Packaages",
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            //Product List
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .wrapContentHeight(),
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(AppColors.PastelColor)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Shop By Skin care",
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                            fontSize = 16.sp,
                            color = AppColors.Primary,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(categories) { category ->
                                Card(
                                    modifier = Modifier
                                        .width(140.dp)
                                        .height(180.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    elevation = CardDefaults.cardElevation(4.dp),
                                    colors = CardDefaults.cardColors(Color.White)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize()
                                    ) {
                                        // Full Image
                                        Image(
                                            painter = painterResource(id = category.imageRes),
                                            contentDescription = category.title,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier.fillMaxSize()
                                        )

                                        // Text at Bottom with translucent background
                                        Box(
                                            modifier = Modifier
                                                .align(Alignment.BottomCenter)
                                                .fillMaxWidth()
                                                .background(Color.Black.copy(alpha = 0.2f))
                                                .padding(vertical = 8.dp)
                                                .clip(CircleShape)
                                        ) {
                                            Text(
                                                text = category.title,
                                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                                fontSize = 14.sp,
                                                color = Color.White,
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                        Button(
                            onClick = { navController.navigate(Routes.PRODUCTS_SCREEN) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp), // Add padding to the sides
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = AppColors.Primary)
                        ) {
                            Text(
                                text = "Shop Products",
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            //product poster
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(Color.Transparent), // Set desired height
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_home_product_off_img),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )

                }
            }

            //package about us
            item {
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                        text = "At Pure Skyn we are focused on providing you with the permanent laser hair removal results that you have always wanted and nothing less. We stand behind our work and ensure that all of our customers are 100% satisfied. If you are looking for laser hair removal in India, please search \"laser hair removal near me\" to find our location and contact us to Book a FREE consultation.",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Justify
                    )
                    Spacer(Modifier.height(16.dp))
                }
            }

        }
    }
}


/*

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}*/
