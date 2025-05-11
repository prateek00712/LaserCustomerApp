package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SimplePagerWithImages2() {
    val pagerState = rememberPagerState(
        pageCount = { 3 },
        initialPage = 0
    )

    val images = listOf(
        R.drawable.img_laser_package_1,
        R.drawable.ic_background_home_2,
        R.drawable.ic_backgroubd_home_3,
        )

    // 👇 Auto-scroll logic
    LaunchedEffect(pagerState) {
        while (true) {
            delay(3000) // 3 seconds
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column( // <-- Use Column to stack Pager and Dots
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Transparent), // Set desired height
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) { page ->
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp)) // Small space between pager and dots

        Row(
            modifier = Modifier
                .wrapContentHeight()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) AppColors.Primary else AppColors.PastelPeach
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(color)
                )
            }
        }
    }
}

@Composable
fun ServiceCard(
    imageRes: Int,
    title: String,
    onClick: () -> Unit
) {
    /*Card(
        modifier = Modifier
            .width(140.dp)
            .height(180.dp)
            .clickable { onClick() }, // Card is clickable
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {*/
    Box(
        modifier = Modifier
            .width(140.dp)
            .height(180.dp)
    ) {
        // Fake red shadow
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(y = 4.dp,x=4.dp) // move down a little
                .background(
                    color = AppColors.Primary.copy(alpha = 0.4f), // Red with opacity
                    shape = RoundedCornerShape(12.dp)
                )
                .blur(radius = 16.dp) // Soft blur to simulate shadow
        )
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(0.dp), // Remove default elevation
            colors = CardDefaults.cardColors(Color.White),
            onClick = { onClick() }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                // Image filling the entire card
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Text at the bottom with translucent black background
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .background(Color.Black.copy(alpha = 0.2f))
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = title,
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

@Composable
fun ServiceCardCopy(
    imageRes: Int,
    title: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(140.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Card with rounded image background
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)), // light bg color like the image
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .size(140.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            fontSize = 14.sp,
            color = AppColors.Primary, // Your brand orange
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ServiceCard2(
    title: String,
    image: Painter,
    price: String,
    time: String,
    descriptionList: List<String>,
    onAddToCart: () -> Unit
) {
    Card(
        modifier = Modifier
//            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = AppColors.NewButtonColor2),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = title,
                        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                        fontSize = 18.sp,
                        color = AppColors.NewTextColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = price,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            color = AppColors.TextPrimary
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Time",
                            modifier = Modifier.size(16.dp),
                            tint = AppColors.TextSecondary
                        )
                        Text(
                            text = time,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            color = AppColors.TextPrimary
                        )
                    }
                }

                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            descriptionList.forEach {
                Row(verticalAlignment = Alignment.Top) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = AppColors.Secondary,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = it,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 14.sp,
                        color = AppColors.Secondary
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
            }

            Text(
                text = "Terms & Conditions Applied *",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontSize = 12.sp,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onAddToCart,
                colors = ButtonDefaults.buttonColors(containerColor = AppColors.NewButtonColor),
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = "Add To Cart",
                    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                    color = Color.White
                )
            }
        }
    }
}
