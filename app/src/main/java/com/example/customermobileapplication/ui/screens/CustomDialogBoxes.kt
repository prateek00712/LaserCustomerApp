package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R

@Composable
fun PackageSelectionDialog(
    title: String,
    subtitle: String,
    packages: List<Pair<String, String>>, // List of (Title, Price)
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    onAddToCart: () -> Unit,
    onBack: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color.White,
            tonalElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.White)
            ) {
// Title
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TextPrimary,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Subtitle
                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.TextPrimary,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Package options
                packages.forEachIndexed { index, (label, price) ->
                    val isSelected = index == selectedIndex
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .border(
                                width = if (isSelected) 2.dp else 1.dp,
                                color = if (isSelected) AppColors.TextPrimary else AppColors.TextSecondary,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(color = if (isSelected) Color.White else AppColors.NewButtonColor2)
                            .clickable { onSelect(index) }
                            .padding(12.dp)
                    ) {
                        Column {
                            Text(
                                text = label,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = AppColors.NewTextColor,
                                fontFamily = FontFamily(Font(R.font.poppins_regular))
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = price,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF007B00), // Green color
                                fontFamily = FontFamily(Font(R.font.poppins_regular))
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Add to Cart Button
                Button(
                    onClick = onAddToCart,
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.NewButtonColor),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = "Add To Cart",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Add to Cart Button
                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.NewButtonColor),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = "Later",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                }
            }
        }
    }
}