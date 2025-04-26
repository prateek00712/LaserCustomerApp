package com.example.customermobileapplication

import android.app.Application
import android.content.Context
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import io.objectbox.BoxStore

@HiltAndroidApp
class CustomerMobileApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Coming inside on create")
        // Initialize ObjectBox
        ObjectBox.init(this)
        // Check if ObjectBox is initialized
        if (ObjectBox.isInitialized()) {
            Log.d(TAG, "✅ ObjectBox initialized successfully")
        } else {
            Log.e(TAG, "❌ ObjectBox initialization failed!")
        }
    }

    companion object{
        const val TAG = "CustomerMobileApplication"
    }
}


