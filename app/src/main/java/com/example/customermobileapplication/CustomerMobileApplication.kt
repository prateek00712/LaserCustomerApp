package com.example.customermobileapplication

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CustomerMobileApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Coming inside on create")
    }

    companion object{
        const val TAG = "CustomerMobileApplication"
    }
}