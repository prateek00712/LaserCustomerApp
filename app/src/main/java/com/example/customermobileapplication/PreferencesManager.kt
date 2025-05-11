package com.example.customermobileapplication

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREF_NAME = "app_preferences"
        private const val KEY_USER_NAME = "key_user_name"
        private const val KEY_IS_LOGGED_IN = "key_is_logged_in"
        private const val KEY_PHONE_NUMBER = "phone_number"
        private const val KEY_NAME = "key_name"
    }

    // Save phone number
    fun savePhoneNumber(phoneNumber: String) {
        sharedPreferences.edit().putString(KEY_PHONE_NUMBER, phoneNumber).apply()
    }

    // Get phone number
    fun getPhoneNumber(): String? {
        return sharedPreferences.getString(KEY_PHONE_NUMBER, null)
    }

    // Save name
    fun saveName(name: String) {
        sharedPreferences.edit().putString(KEY_NAME, name).apply()
    }

    // Get name
    fun getName(): String? {
        return sharedPreferences.getString(KEY_NAME, null)
    }

    // Save string data
    fun saveUserName(userName: String) {
        sharedPreferences.edit().putString(KEY_USER_NAME, userName).apply()
    }

    // Get string data
    fun getUserName(): String? {
        return sharedPreferences.getString(KEY_USER_NAME, null)
    }

    // Save boolean data
    fun saveLoginStatus(isLoggedIn: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_IS_LOGGED_IN, isLoggedIn).apply()
    }

    // Get boolean data
    fun getLoginStatus(): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    // Clear all preferences
    fun clearPreferences() {
        sharedPreferences.edit().clear().apply()
    }
}
