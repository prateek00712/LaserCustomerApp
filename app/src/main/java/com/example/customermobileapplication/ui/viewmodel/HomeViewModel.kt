package com.example.customermobileapplication.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customermobileapplication.data.api.data.model.Data
import com.example.customermobileapplication.data.api.data.model.ProductResponse
import com.example.customermobileapplication.data.remote.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel(){

    init {
        Log.d("Homeviewmodel","Init block view model")
    }

    var products = mutableStateOf<List<Data>>(emptyList())
        private set

    var isLoading = mutableStateOf(true)
        private set

   /* init {
        getProductList()
    }*/

    fun getProductList() {
        viewModelScope.launch {
            Log.d("HomeViewModel", "Calling getProducts API...")
            try {
                val response = RetrofitInstance.api.getProducts()
                Log.d("HomeViewModel", "API Response Status: ${response.status}")
                Log.d("HomeViewModel", "API Response Message: ${response.message}")
                Log.d("HomeViewModel", "Number of Products: ${response.data.size}")

                if (response.status == "SUCCESS") {
                    products.value = response.data
                    response.data.forEach { product ->
                        Log.d("HomeViewModel", "Product: ${product.productName}")
                    }
                }
            } catch (e: Exception) {
                Log.e("HomeViewModel", "API call failed: ${e.localizedMessage}", e)
            } finally {
                isLoading.value = false
                Log.d("HomeViewModel", "Loading completed")
            }
        }
    }


}