package com.example.customermobileapplication.data.api.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ProductsAdditionalDetail(
    @SerializedName("content")
    val content: String,
    @SerializedName("detailsId")
    val detailsId: String,
    @SerializedName("name")
    val name: String
)