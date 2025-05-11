package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.data.api.data.Product
import com.example.customermobileapplication.ui.navigation.Routes
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel
@Composable
fun ProductsScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()

){
    /*val products = homeViewModel.products
    val isLoading = homeViewModel.isLoading

    // Get product list when the screen is composed
    LaunchedEffect(Unit) {
        homeViewModel.getProductList()
    }
    // Log all data once it's loaded and not empty
    LaunchedEffect(products.value) {
        if (products.value.isNotEmpty()) {
            products.value.forEach { product ->
                Log.d("ProductScreen", "Product Name: ${product.productName}")
                // Add more fields if you want to print additional data
                Log.d("ProductScreen", "Product Price: ${product.productPrice}")
                Log.d("ProductScreen", "Product Description: ${product.productDescription}")
                Log.d("ProductScreen", "Product Category: ${product.category}")
            }
        } else {
            Log.d("ProductScreen", "No products available")
        }
    }*/


    val categories = listOf("all products", "Face Serum", "Face Wash","Moisturizer","Pigmentation","Skin Antioxidant","Sunscreen")
    var selectedCategory = remember { mutableStateOf(categories[0]) }

    val products = listOf(
        Product("Agelite-X Serum", R.drawable.ic_face_serum, 999, 3999, 37,"Face Serum"),
        Product("Agelite Vitamin C Face Wash", R.drawable.ic_face_wash_img, 999, 3999, 37, "Face Wash"),
        Product("Relizema Ultra Hydrating Lotion", R.drawable.ic_moisturizer_img, 655, 3999, 37, "Moisturizer"),
        Product("Melalumin Ultra Depigmenting Cream", R.drawable.ic_pigemntation_img, 499, 3999, 37, "Pigmentation"),
        Product("Skinjoy-GL Fizz Effervescent Tablet", R.drawable.ic_skin_antioxi_img, 999, 3999, 37,"Skin Antioxidant"),
        Product("Dermatica Ray Protect Barelyon Fluid Sunscreen SPF 50", R.drawable.ic_sunscreen_img, 2250, 3999, 37,"Sunscreen"),
        // Add more products if needed
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .padding(16.dp)
    ) {
        Text(
            text = "shop all",
            fontSize = 24.sp,
//            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            color = AppColors.TextPrimary
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow {
            items(categories) { category ->
                val isSelected = category == selectedCategory.value
                Box(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(if (isSelected) AppColors.PastelPeach else Color.Transparent)
                        .clickable { selectedCategory.value = category }
                ) {
                    Text(
                        text = category,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        color = if (isSelected) AppColors.Primary else AppColors.TextSecondary,
                        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                        fontSize = 14.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val filteredProducts = if (selectedCategory.value == "all products") {
            products
        } else {
            products.filter { it.category == selectedCategory.value }
        }


        LazyColumn {
            items(filteredProducts) { product ->
                ProductItem(product = product) {
                    when (product.category) {
                        "Face Wash" -> navController.navigate(Routes.PRODUCT_DETAIL_WASH)
                        "Face Serum" -> navController.navigate(Routes.PRODUCT_DETAIL_SERUM)
                        "Moisturizer" -> navController.navigate(Routes.PRODUCT_DETAIL_MOISTURIZER)
                        "Pigmentation" -> navController.navigate(Routes.PRODUCT_DETAIL_PIGMENTATION)
                        "Skin Antioxidant" -> navController.navigate(Routes.PRODUCT_DETAIL_ANTIOXIDANT)
                        "Sunscreen" -> navController.navigate(Routes.PRODUCT_DETAIL_SUNSCREEN)
                        else -> navController.navigate(Routes.PRODUCT_DETAIL_WASH)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }


    }
}

@Composable
fun ProductItem(product: Product,onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(Color.White),

    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                product.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = AppColors.TextPrimary,
                fontFamily = FontFamily(Font(R.font.poppins_regular))
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "₹ ${product.discountPrice}",
                    fontWeight = FontWeight.Bold,
                    color = AppColors.Primary,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "₹ ${product.originalPrice}",
                    textDecoration = TextDecoration.LineThrough,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semi_bold))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "${product.discountPercent}% off",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semi_bold))
                )
            }
        }
    }
}

