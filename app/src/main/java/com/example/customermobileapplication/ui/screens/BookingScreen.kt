package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.data.entity.CartItemServices
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel
import com.example.customermobileapplication.ui.viewmodel.ServiceViewModel
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear

@Composable
fun BookingScreen(
    serviceViewModel: ServiceViewModel = hiltViewModel()
) {
    val services by serviceViewModel.cartItems.collectAsState()
//    val totalPrice = services.sumOf { it.price.replace(",", "").toIntOrNull() ?: 0 }
    val selectedTab = remember { mutableStateOf("Product") }
//    val services by serviceViewModel.cartItems.collectAsState()
    val products = serviceViewModel.productQuantities
    val productItems = products.entries.toList()
    val totalPrice = if (selectedTab.value == "Services") {
        services.sumOf { it.price.replace(",", "").toIntOrNull() ?: 0 }
    } else {
        productItems.sumOf { (title, qty) ->
            val item = serviceViewModel.getProductItemByTitle(title)
            (item?.price?.replace(",", "")?.toIntOrNull() ?: 0) * qty
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .padding(16.dp)
    ) {
        // Tabs with underline for selected tab
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .clickable { selectedTab.value = "Product" }
            ) {
                Text(
                    text = "Product",
                    color = if (selectedTab.value == "Product") AppColors.Primary else AppColors.TextSecondary,
                    fontWeight = if (selectedTab.value == "Product") FontWeight.Bold else FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
                Spacer(modifier = Modifier.height(4.dp))
                if (selectedTab.value == "Product") {
                    Box(
                        modifier = Modifier
                            .height(2.dp)
                            .fillMaxWidth()
                            .background(AppColors.Primary, RoundedCornerShape(1.dp))
                    )
                } else {
                    Spacer(modifier = Modifier.height(2.dp))
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .clickable { selectedTab.value = "Services" }
            ) {
                Text(
                    text = "Services",
                    color = if (selectedTab.value == "Services") AppColors.Primary else AppColors.TextSecondary,
                    fontWeight = if (selectedTab.value == "Services") FontWeight.Bold else FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
                Spacer(modifier = Modifier.height(4.dp))
                if (selectedTab.value == "Services") {
                    Box(
                        modifier = Modifier
                            .height(2.dp)
                            .fillMaxWidth()
                            .background(AppColors.Primary, RoundedCornerShape(1.dp))
                    )
                } else {
                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        if (
            (selectedTab.value == "Services" && services.isEmpty()) ||
            (selectedTab.value == "Product" && productItems.isEmpty())
        ) {
            // Empty state UI
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = if (selectedTab.value == "Services"){
                            R.drawable.ic_no_appointment_img}
                            else{
                                R.drawable.ic_no_orders_img
                            }
                        ), // Replace with your actual image
                        contentDescription = "No items",
                        modifier = Modifier.size(120.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = if (selectedTab.value == "Services") "No services added" else "No products added",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight.Medium,
                        color = AppColors.TextSecondary
                    )
                }
            }
        } else {
            // List - takes available vertical space
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                if (selectedTab.value == "Services") {
                    items(services) { item ->
                        ServiceCartItemCard(item, onRemove = {
                            serviceViewModel.removeFromCart(item.id)
                        })
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                } else {
                    items(productItems) { (title, quantity) ->
                        val product = serviceViewModel.getProductItemByTitle(title)
                        if (product != null) {
                            ProductCartItemCard(
                                title = title,
                                quantity = quantity,
                                price = product.price,
                                onIncrease = { serviceViewModel.increaseQuantity(title) },
                                onDecrease = { serviceViewModel.decreaseQuantity(title) }
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                }
            }
        }

        // Bottom Section: total price + checkout button
        Divider(thickness = 1.dp, color = AppColors.TextSecondary.copy(alpha = 0.2f))
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Total Value ₹$totalPrice",
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontSize = 16.sp,
            color = AppColors.Primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* navigate to checkout */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = AppColors.Primary),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Checkout",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Composable
fun ServiceCartItemCard(item: CartItemServices, onRemove: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, AppColors.TextSecondary.copy(alpha = 0.2f)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Static image on the left
            Image(
                painter = painterResource(
                    id =
                    if (item.subtitle == "Full Body Women") {
                        R.drawable.ic_women_full_body_img
                    } else if (item.subtitle == "Full Body Men") {
                        R.drawable.ic_man_full_body_img
                    } else if (item.subtitle == "Chest & Back") {
                        R.drawable.ic_men_chest_back_img
                    } else if (item.subtitle == "Bikini & Buttocks") {
                        R.drawable.ic_bikini_img
                    } else if (item.subtitle == "Chest") {
                        R.drawable.ic_chest_back_img
                    } else if (item.subtitle == "Face & Neck") {
                        R.drawable.ic_face_neck_img
                    } else if (item.subtitle == "Arms & Underarms") {
                        R.drawable.ic_arms_under_img
                    } else if (item.subtitle == "Oxy Hydra Facial") {
                        R.drawable.ic_oxy_hydra_facial_icon_img
                    } else if (item.subtitle == "Oxygeneo Facial") {
                        R.drawable.ic_oxygeneo_package
                    } else if (item.subtitle == "Derma Infusion Facial") {
                        R.drawable.ic_dermafrac_skin_img
                    } else if (item.subtitle == "RF Skin Tightening") {
                        R.drawable.ic_rf_skin_tight_img
                    } else if (item.title == "Laser Hair Reduction - Female") {
                        R.drawable.home_laser_skin_removal
                    } else if (item.title == "Laser Hair Reduction - Male") {
                        R.drawable.home_laser_skin_men
                    } else if (item.title == "Oxy Hydra Facial + Oxygeneo Therapy") {
                        R.drawable.custom_package_hydra_geneo
                    } else if (item.title == "Oxy Hydra Facial + Oxygeno + Dermafrac") {
                        R.drawable.custome_package_geneo_derma_hydra
                    } else if (item.title == "Oxygeneo + Dermafrac") {
                        R.drawable.custom_image_geneo_derma
                    } else if (item.title == "Oxy Hydra Facial + Dermafra") {
                        R.drawable.custom_package_hydra_derma
                    } else {
                        R.drawable.ic_face_neck_img
                    }
                ), // Replace with your image file name
                contentDescription = "Service Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Text details
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${item.title} - ${item.subtitle}",
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TextPrimary,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
                Text(
                    text = item.sessions,
                    color = AppColors.TextSecondary,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
                Text(
                    text = "₹${item.price}",
                    fontWeight = FontWeight.Bold,
                    color = AppColors.Primary,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            }

            // Remove button
            IconButton(onClick = onRemove) {
                Icon(Icons.Default.Close, contentDescription = "Remove")
            }
        }
    }
}


@Composable
fun ProductCartItemCard(
    title: String,
    quantity: Int,
    price: String,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, AppColors.TextSecondary.copy(alpha = 0.2f)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Product image
            Image(
                painter = painterResource(
                    id = if (title == "Agelite-X Serum") {
                        R.drawable.ic_face_serum
                    } else if (title == "Agelite Vitamin C Face Wash") {
                        R.drawable.ic_face_wash_img
                    } else if (title == "Relizema Ultra Hydrating Lotion") {
                        R.drawable.ic_moisturizer_img
                    } else if (title == "Melalumin Ultra Depigmenting Cream") {
                        R.drawable.ic_pigemntation_img
                    }else if (title == "Skinjoy-GL Fizz Effervescent Tablet") {
                        R.drawable.ic_skin_antioxi_img
                    }else if (title == "Dermatica Ray Protect Barelyon Fluid Sunscreen SPF 50") {
                        R.drawable.ic_sunscreen_img
                    } else {
                        R.drawable.ic_sunscreen_img
                    }
                ), // Replace with your actual image
                contentDescription = "Product Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(4.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    maxLines = 2,
                    color = AppColors.TextPrimary
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "₹$price",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = AppColors.Primary,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                }
            }

            // Quantity controls
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(start = 8.dp, end = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(AppColors.Primary.copy(alpha = 0.1f))
                        .clickable(onClick = onDecrease),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.minus_svg),
                        contentDescription = "Decrease",
                        modifier = Modifier.size(14.dp),
                        tint = AppColors.Primary
                    )
                }

                Text(
                    text = quantity.toString(),
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight.Medium,
                    color = AppColors.TextPrimary
                )

                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(AppColors.Primary.copy(alpha = 0.1f))
                        .clickable(onClick = onIncrease),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.plus_svg),
                        contentDescription = "Increase",
                        modifier = Modifier.size(14.dp),
                        tint = AppColors.Primary
                    )
                }
            }
        }
    }
}


/*
@Composable
fun ProductCartItemCard(
    title: String,
    quantity: Int,
    price: String,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, AppColors.TextSecondary.copy(alpha = 0.2f)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.poppins_medium)))
                Text("Price: ₹$price", fontFamily = FontFamily(Font(R.font.poppins_regular)))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onDecrease) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Decrease")
                }
                Text(quantity.toString(), modifier = Modifier.padding(horizontal = 8.dp))
                IconButton(onClick = onIncrease) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Increase")
                }
            }
        }
    }
}
*/

