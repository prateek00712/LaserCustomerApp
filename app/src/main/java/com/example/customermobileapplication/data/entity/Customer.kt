package com.example.customermobileapplication.data.entity

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Keep
@Entity
data class Customer(
    @Id
    @SerializedName("id")
    var id: Long = 0,
    @SerializedName("name")
    var name: String,
    @SerializedName("email")
    var email: String
)