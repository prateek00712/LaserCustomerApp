package com.example.customermobileapplication.data.api.data

data class Product(
    val name: String,
    val imageRes: Int,
    val discountPrice: Int,
    val originalPrice: Int,
    val discountPercent: Int,
    val category: String
)
