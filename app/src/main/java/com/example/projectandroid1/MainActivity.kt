package com.example.projectandroid1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.projectandroid1.Helper.UserHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!UserHelper(this).StatusSplash) {
            val home = Intent(this, Splash::class.java)
            startActivity(home)
            finish()
        } else {
            Handler().postDelayed({
                val home = Intent(this, Home::class.java)
                startActivity(home)
                finish()
            }, 2000)
        }
    }
}
