package com.example.customermobileapplication.data.entity

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Keep
@Entity
data class ProductItemCart(
    @Id
    @SerializedName("id")
    var id: Long = 0,
    @SerializedName("title")
    var title: String,
    @SerializedName("price")
    var price: String,
    @SerializedName("quantity")
    var quantity: Int = 0,
)
