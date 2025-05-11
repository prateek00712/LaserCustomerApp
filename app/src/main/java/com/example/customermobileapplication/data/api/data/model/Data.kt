package com.example.customermobileapplication.data.api.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Data(
    @SerializedName("allImages")
    val allImages: List<String>,
    @SerializedName("category")
    val category: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("imgSrc")
    val imgSrc: String,
    @SerializedName("productDescription")
    val productDescription: String,
    @SerializedName("productId")
    val productId: String,
    @SerializedName("productName")
    val productName: String,
    @SerializedName("productPrice")
    val productPrice: String,
    @SerializedName("productsAdditionalDetails")
    val productsAdditionalDetails: List<ProductsAdditionalDetail>,
    @SerializedName("ratings")
    val ratings: Int,
    @SerializedName("smallDescription")
    val smallDescription: List<String>
)