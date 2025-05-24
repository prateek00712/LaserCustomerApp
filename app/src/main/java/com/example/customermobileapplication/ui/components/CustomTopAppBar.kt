package com.example.customermobileapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R


//@Composable
@Composable
fun CustomTopAppBar(
    onMenuClick: () -> Unit,
    onCartClick: () -> Unit,
    cartCount: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFE6A88E), // Pastel peach
                        Color(0xFFF6D9CB)  // Lighter complementary color
                    )
                )
            )
            .height(72.dp)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onMenuClick) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = AppColors.TextPrimary
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_logo_homepage),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 8.dp)
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_customer_service_2),
                        contentDescription = "Customer Support",
                        tint = AppColors.TextPrimary,
                        modifier = Modifier.size(24.dp)
                    )
                }

                // Cart Icon with badge
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 4.dp)
                ) {
                    IconButton(onClick = onCartClick) {
                        Icon(
                            painter = painterResource(R.drawable.ic_cart),
                            contentDescription = "Cart",
                            tint = AppColors.TextPrimary,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    if (cartCount > 0) {
                        Box(
                            modifier = Modifier
                                .size(18.dp)
                                .background(Color.Red, shape = CircleShape)
                                .align(Alignment.TopEnd),
//                                .offset(x = (-1).dp, y = 1.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = cartCount.toString(),
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                lineHeight = 10.sp, // force vertical centering
                                modifier = Modifier.padding(1.dp) // optional slight padding
                            )
                        }
                    }

                }
            }
        }
    }
}

/*
fun CustomTopAppBar(
    onMenuClick: () -> Unit,
    onCartClick: () -> Unit,
    cartCount: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFE6A88E), // Pastel peach
                        Color(0xFFF6D9CB)  // Lighter complementary color
                    )
                )
            )
            .height(72.dp)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Menu Icon
                IconButton(onClick = onMenuClick) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = AppColors.TextPrimary
                    )
                }

                Spacer(modifier = Modifier.width(8.dp)) // Small space between menu and logo

                // Logo
                Image(
                    painter = painterResource(id = R.drawable.ic_logo_homepage), // Replace with your image
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 16.dp)
            ) {
                // New Extra SVG (your custom icon)
                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_customer_service_2),
                        contentDescription = "Extra Action",
                        tint = AppColors.TextPrimary,
                        modifier = Modifier.size(24.dp)

                    )
                }

                //cart icon
                IconButton(onClick = onCartClick) {
                    Box(
                        modifier = Modifier
                            .size(32.dp), // wrapper size to give enough room
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_cart),
                            contentDescription = "Cart",
                            tint = AppColors.TextPrimary,
                            modifier = Modifier.size(24.dp)
                        )

                        if (cartCount > 0) {
                            Box(
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .offset(x = 4.dp, y = (-4).dp) // fine-tuned placement
                                    .size(16.dp)
                                    .background(Color.Red, shape = CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = cartCount.toString(),
                                    color = Color.White,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }

            }
        }
    }

}
*/
