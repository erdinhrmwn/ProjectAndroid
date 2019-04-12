package com.example.projectandroid1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.projectandroid1.Helper.UserHelper


class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        Handler().postDelayed({
            val home = Intent(this, MainActivity::class.java)
            startActivity(home)
            UserHelper(this).StatusSplash = true
            finish()
        }, 3000)
    }
}