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

@Composable
fun LaserHairRemovalScreenWomen(navController: NavController) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .padding(horizontal = 16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Laser Hair Removal Women At Home",
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                fontSize = 20.sp,
                color = AppColors.NewTextColor
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
        /*item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { *//* View Cart *//* },
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.NewButtonColor),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "View Cart",
                        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                        color = Color.White
                    )
                }

                Button(
                    onClick = { *//* Empty Cart *//* },
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.NewButtonColor),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Empty Cart",
                        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }*/
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
            val image = painterResource(id = R.drawable.ic_women_full_body_img)
            ServiceCard2(
                title = "Full Body",
                image = image,
                price = "₹15,000",
                time = "60 mins",
                descriptionList = listOf(
                    "Say goodbye to painful waxing and shaving forever!",
                    "Covers full body, including arms, legs, underarms, and bikini line."
                ),
                onAddToCart = { /* Handle Add to Cart */ }
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
            onAddToCart = { /* Handle Add to Cart */ })
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image3 = painterResource(id = R.drawable.ic_bikini_img)

            ServiceCard2(
                title = "Bikini & Buttocks",
                price = "₹6,000",
                time = "60 mins",
                image = image3,
                descriptionList = listOf(
                    "Achieve smooth, hair-free skin with long-lasting results.",
                    "Safe, effective, and designed for sensitive areas."
                ),
                onAddToCart = { /* Handle Add to Cart */ }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image4 = painterResource(id = R.drawable.ic_chest_back_img)
            ServiceCard2(
                title = "Chest & Back",
                price = "₹8,000",
                time = "60 mins",
                image = image4,
                descriptionList = listOf(
                    "Get a clean, groomed look with long-lasting hair reduction.",
                    "Say goodbye to painful waxing and frequent shaving."
                ),
                onAddToCart = { /* Handle Add to Cart */ }
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
                onAddToCart = { /* Handle Add to Cart */ }
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
                onAddToCart = { /* Handle Add to Cart */ }
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
                onAddToCart = { /* Handle Add to Cart */ }
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
                onAddToCart = { /* Handle Add to Cart */ }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image9 = painterResource(id = R.drawable.ic_chest_back_img)
            ServiceCard2(
                title = "Chest",
                price = "₹5,000",
                time = "60 mins",
                image = image9,
                descriptionList = listOf(
                    "Get a hair-free chest with advanced laser technology for smooth skin.",
                    "Say goodbye to frequent waxing and shaving hassles."
                ),
                onAddToCart = { /* Handle Add to Cart */ }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            val image10 = painterResource(id = R.drawable.ic_bikini_img)
            ServiceCard2(
                title = "Bikini",
                price = "₹5,000",
                time = "60 mins",
                image = image10,
                descriptionList = listOf(
                    "Achieve a perfectly groomed bikini area with precision laser treatment.",
                    "No more irritation or ingrown hairs from waxing or shaving."
                ),
                onAddToCart = { /* Handle Add to Cart */ }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}