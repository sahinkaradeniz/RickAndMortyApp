package com.example.common.util

import android.content.Context
import android.content.SharedPreferences


class SplashSharedPreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(preferences, Context.MODE_PRIVATE)

    fun setLogin() {
        sharedPreferences.edit().putBoolean(splashKey,true).apply()
    }

    fun firstLoginCheck(): Boolean {
        return sharedPreferences.getBoolean(splashKey,false)
    }

    companion object{
        const val preferences="splashPreferences"
        const val splashKey="splash"
    }
}

