package com.example.customermobileapplication.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customermobileapplication.ObjectBox
import com.example.customermobileapplication.data.api.data.model.Data
import com.example.customermobileapplication.data.entity.CartItemServices
import com.example.customermobileapplication.data.entity.Customer
import com.example.customermobileapplication.data.entity.Customer_
import com.example.customermobileapplication.data.entity.ProductItemCart
import com.example.customermobileapplication.data.remote.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import io.objectbox.Box
import io.objectbox.query.QueryBuilder
import io.objectbox.reactive.DataSubscription
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
): ViewModel(){

   /* init {
        Log.d("Homeviewmodel","Init block view model")
    }*/
    val customerBox = ObjectBox.boxFor(Customer::class.java)
    val cartBox = ObjectBox.boxFor(CartItemServices::class.java)
    private val _cartCount = mutableStateOf(0)
    val cartCount: State<Int> = _cartCount
    private val productBox = ObjectBox.boxFor(ProductItemCart::class.java)


    fun refreshCustomerCount() {
//        val productCount = productBox.count().toInt()
//        _cartCount.value = cartBox.count().toInt()
        val serviceCount = cartBox.count().toInt()
        val productCount = productBox.count().toInt()
        _cartCount.value = serviceCount + productCount
    }

    private var subscription: DataSubscription? = null
    private var productSubscription: DataSubscription? = null
    init {
        observeCustomerCount()
    }

    private fun observeCustomerCount() {
        subscription?.cancel()
        productSubscription?.cancel()

        subscription = cartBox.query().build().subscribe().observer {
            refreshCustomerCount()
        }

        productSubscription = productBox.query().build().subscribe().observer {
            refreshCustomerCount()
        }
//        subscription?.cancel()
//        subscription = cartBox.query().build().subscribe().observer { _ ->
//            refreshCustomerCount()
////            _cartCount.value = cartBox.count().toInt()
//        }
    }

    override fun onCleared() {
        super.onCleared()
        subscription?.cancel()
        productSubscription?.cancel()
    }

//    val newCustomer = Customer(name = "Alice", email = "alice@email.com")

    fun saveCustomerWithLog(name: String, email: String) {
        val customer = Customer(name = name, email = email)
        val id = customerBox.put(customer)

        // Verify if it was stored
        val isStored = customerBox.contains(id)
        refreshCustomerCount() // Update count after modification
        if (isStored) {
            Log.d("HomeViewModel", "Customer saved successfully with ID: $id")
        } else {
            Log.e("HomeViewModel", "Failed to save customer.")
        }
    }

    fun logCustomerCount() {
        val count = customerBox.count()
        val data = customerBox.all
        Log.d("HomeViewModel", "Total customers in ObjectBox: $count")
        Log.d("HomeViewModel", "Total customers in ObjectBox: ${data}")
    }

    fun deleteLastCustomer() {
        val lastCustomer = customerBox.query()
            .order(Customer_.id, QueryBuilder.DESCENDING)
            .build()
            .findFirst()
        refreshCustomerCount()
        if (lastCustomer != null) {
            customerBox.remove(lastCustomer)
            refreshCustomerCount() // <-- updates the customer count after deletion
            Log.d("HomeViewModel", "Deleted last customer: $lastCustomer")
        } else {
            Log.d("HomeViewModel", "No customer to delete")
        }
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