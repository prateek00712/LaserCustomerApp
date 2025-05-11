package com.example.customermobileapplication.data.remote

import com.example.customermobileapplication.data.api.data.model.ProductResponse
import retrofit2.http.GET

interface ProductApiService {
    @GET("products/all") // Replace with actual endpoint
    suspend fun getProducts(): ProductResponse
}
