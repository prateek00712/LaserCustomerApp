package com.example.customermobileapplication.data

data class ProductDetail(
    val name: String,
    val price: Int,
    val imageResIds: List<Int>,
    val shortDescription: String,
    val productDetails: String,
    val benefits: String,
    val howToUse: String,
    val contents: String
)
