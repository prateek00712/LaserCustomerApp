package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel

@Composable
fun MediFacialPackageScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
){
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
            text = "MEDI-FACIAL PRIME PACKAGES",
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            fontSize = 18.sp,
            color = AppColors.Primary,
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(2.dp)
        ) {
            item {
                Row {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 8.dp)
                            .wrapContentHeight(),
                        elevation = CardDefaults.cardElevation(4.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(AppColors.PastelColor)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_oxy_hydra_package), // Replace with your image
                                contentDescription = null,
                                modifier = Modifier
                                    .height(100.dp)
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(16.dp)) // Add space before the button

                            Text(
                                text = "Oxy Hydra facial\n       ",
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                fontSize = 16.sp,
                                color = AppColors.Primary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "₹5000",
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                fontSize = 16.sp,
                                color = AppColors.TextPrimary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
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
                                    text = "Book Now",
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 8.dp)
                            .wrapContentHeight(),
                        elevation = CardDefaults.cardElevation(4.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(AppColors.PastelColor)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_skin_tight), // Replace with your image
                                contentDescription = null,
                                modifier = Modifier
                                    .height(100.dp)
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(16.dp)) // Add space before the button

                            Text(
                                text = "RF Skin Tightening",
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                fontSize = 16.sp,
                                color = AppColors.Primary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "₹5000",
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                fontSize = 16.sp,
                                color = AppColors.TextPrimary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
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
                                    text = "Book Now",
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 8.dp)
                            .wrapContentHeight(),
                        elevation = CardDefaults.cardElevation(4.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(AppColors.PastelColor)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_dermafrac_package), // Replace with your image
                                contentDescription = null,
                                modifier = Modifier
                                    .height(100.dp)
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(16.dp)) // Add space before the button

                            Text(
                                text = "Dermafrac Infusion Facial",
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                fontSize = 16.sp,
                                color = AppColors.Primary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "₹10000",
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                fontSize = 16.sp,
                                color = AppColors.TextPrimary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
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
                                    text = "Book Now",
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 8.dp)
                            .wrapContentHeight(),
                        elevation = CardDefaults.cardElevation(4.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(AppColors.PastelColor)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_oxygeneo_package), // Replace with your image
                                contentDescription = null,
                                modifier = Modifier
                                    .height(100.dp)
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(16.dp)) // Add space before the button

                            Text(
                                text = "Oxygeneo",
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                fontSize = 16.sp,
                                color = AppColors.Primary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "₹5000",
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                fontSize = 16.sp,
                                color = AppColors.TextPrimary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
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
                                    text = "Book Now",
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}