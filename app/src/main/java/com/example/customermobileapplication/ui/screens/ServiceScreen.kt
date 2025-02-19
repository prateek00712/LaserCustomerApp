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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel

@Composable
fun ServiceScreen(
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
            text = "Services",
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
            //Laser Hair Removal Men
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
                        text = "Laser Hair Removal Men",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.laser_hair_men), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                    Button(
                        onClick = { /* TODO: Handle Know More & Book Now action */ },
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

            //Laser Hair Removal Women
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
                        text = "Laser Hair Removal Women",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.laser_hair_women), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                    Button(
                        onClick = { /* TODO: Handle Know More & Book Now action */ },
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

            //Oxy Hydra facial
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
                        text = "Oxy Hydra facial",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.oxy_hydra_facial), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                    Button(
                        onClick = { /* TODO: Handle Know More & Book Now action */ },
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

            //RF Skin tightening
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
                        text = "RF Skin Tightening",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.rf_skin_tightening), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                    Button(
                        onClick = { /* TODO: Handle Know More & Book Now action */ },
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

            //DermaFrac
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
                        text = "Dermafrac Infusion Facial",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.deramfrac_infusion_facial), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                    Button(
                        onClick = { /* TODO: Handle Know More & Book Now action */ },
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
            //Oxygeneo
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
                        text = "Oxygeneo",
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 16.sp,
                        color = AppColors.Primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.oxygeneo), // Replace with your image
                        contentDescription = null,
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // Add space before the button
                    Button(
                        onClick = { /* TODO: Handle Know More & Book Now action */ },
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
