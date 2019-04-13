package com.example.projectandroid1.Helper

import android.content.Context
import android.preference.PreferenceManager

class UserHelper(ctx: Context) {
    private val preferences = PreferenceManager.getDefaultSharedPreferences(ctx)

    var StatusSplash = preferences.getBoolean("SPLASH", false)
        set(value) = preferences.edit().putBoolean("SPLASH", value).apply()

    var StatusLogin = preferences.getBoolean("LOGIN", false)
        set(value) = preferences.edit().putBoolean("LOGIN", value).apply()

    var Name = preferences.getString("nama", "User")
        set(value) = preferences.edit().putString("nama", value).apply()
}