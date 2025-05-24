package com.example.customermobileapplication.ui.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.customermobileapplication.ObjectBox
import com.example.customermobileapplication.data.ProductDetail
import com.example.customermobileapplication.data.entity.CartItemServices
import com.example.customermobileapplication.data.entity.CartItemServices_
import com.example.customermobileapplication.data.entity.Customer
import com.example.customermobileapplication.data.entity.ProductItemCart
import com.example.customermobileapplication.data.entity.ProductItemCart_
import dagger.hilt.android.lifecycle.HiltViewModel
import io.objectbox.Box
import io.objectbox.query.QueryBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ServiceViewModel @Inject constructor() : ViewModel() {

    private val cartBox = ObjectBox.boxFor(CartItemServices::class.java)
    private val _cartCount = mutableStateOf(0)
    val cartCount: State<Int> = _cartCount
    private val productBox = ObjectBox.boxFor(ProductItemCart::class.java)

    // ✅ Reactive product items
    private val _productItems = MutableStateFlow<List<ProductItemCart>>(emptyList())
    val productItems: StateFlow<List<ProductItemCart>> = _productItems
    private val _productQuantities = mutableStateMapOf<String, Int>()
    val productQuantities: Map<String, Int> get() = _productQuantities


    fun refreshCustomerCount() {
        _cartCount.value = cartBox.count().toInt()
    }

    private val _cartItems = MutableStateFlow<List<CartItemServices>>(emptyList())
    val cartItems: StateFlow<List<CartItemServices>> = _cartItems

    init {
        loadCart()
        loadProducts()
        loadProductQuantities()
    }

    private fun loadProductQuantities() {
        val items = productBox.all
        _productQuantities.clear()
        items.forEach {
            _productQuantities[it.title] = it.quantity
        }
    }

    private fun loadProducts() {
        _productItems.value = productBox.all
    }

    private fun loadCart() {
        _cartItems.value = cartBox.all
    }

    fun removeFromCart(id: Long) {
        cartBox.remove(id)
        loadCart()
    }

    fun savePackageToCart(
        title: String,
        subtitle: String,
        sessions: String,
        serviceType: String,
        price: String,
        context: Context
    ) {

        // Check if item with same subtitle already exists
        val exists = cartBox.query()
            .equal(CartItemServices_.subtitle, subtitle, QueryBuilder.StringOrder.CASE_INSENSITIVE)
            .and()
            .equal(CartItemServices_.title, title, QueryBuilder.StringOrder.CASE_INSENSITIVE)
            .build()
            .findFirst() != null

        if (exists) {
            Toast.makeText(context, "Service already added to cart", Toast.LENGTH_SHORT).show()
            return
        }


        val cartItem = CartItemServices(
            // id = 0 // leave 0 for ObjectBox to auto-generate ID
            title = title,
            subtitle = subtitle,
            sessions = sessions,
            serviceType = serviceType,
            price = price
        )
        cartBox.put(cartItem)
        Toast.makeText(context, "Service added to cart", Toast.LENGTH_SHORT).show()
    }



    fun getProductItemByTitle(title: String): ProductItemCart? {
        return _productItems.value.find { it.title == title }
    }
    fun addProduct(product: ProductDetail) {
        val current = _productQuantities[product.name] ?: 0
        if (current == 0) {
            val newItem = ProductItemCart(
                title = product.name,
                price = product.price.toString(),
                quantity = 1
            )
            productBox.put(newItem)
        } else {
            val existing = productBox.query()
                .equal(ProductItemCart_.title, product.name,QueryBuilder.StringOrder.CASE_INSENSITIVE)
                .build()
                .findFirst()
            if (existing != null) {
                existing.quantity += 1
                productBox.put(existing)
            }
        }
        _productQuantities[product.name] = current + 1
    }

   /* fun addProduct(product: ProductDetail) {
        val existing = getProductItemByTitle(product.name)
        if (existing != null) {
            existing.quantity += 1
            productBox.put(existing)
        } else {
            val newItem = ProductItemCart(
                title = product.name,
                price = product.price.toString(),
                quantity = 1
            )
            productBox.put(newItem)
        }
        loadProducts()
    }*/

    fun increaseQuantity(title: String) {
        val current = _productQuantities[title] ?: 0
        val item = productBox.query().equal(ProductItemCart_.title, title,QueryBuilder.StringOrder.CASE_INSENSITIVE).build().findFirst()
        if (item != null) {
            item.quantity += 1
            productBox.put(item)
            _productQuantities[title] = item.quantity
        }
    }
/*

    fun increaseQuantity(title: String) {
        getProductItemByTitle(title)?.let {
            it.quantity += 1
            productBox.put(it)
            loadProducts()
        }
    }
*/
fun decreaseQuantity(title: String) {
    val current = _productQuantities[title] ?: 0
    val item = productBox.query().equal(ProductItemCart_.title, title,QueryBuilder.StringOrder.CASE_INSENSITIVE).build().findFirst()
    if (item != null) {
        if (item.quantity > 1) {
            item.quantity -= 1
            productBox.put(item)
            _productQuantities[title] = item.quantity
        } else {
            productBox.remove(item)
            _productQuantities.remove(title)
        }
    }
}
/*
    fun decreaseQuantity(title: String) {
        getProductItemByTitle(title)?.let {
            if (it.quantity > 1) {
                it.quantity -= 1
                productBox.put(it)
            } else {
                productBox.remove(it)
            }
            loadProducts()
        }
    }*/

}
