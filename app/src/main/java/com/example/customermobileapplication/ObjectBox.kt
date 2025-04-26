package com.example.customermobileapplication

import android.content.Context
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var store: BoxStore
        private set

    fun init(context: Context) {
        store = MyObjectBox.builder()
            .androidContext(context)
            .build()
    }
    fun isInitialized(): Boolean {
        return this::store.isInitialized
    }
}