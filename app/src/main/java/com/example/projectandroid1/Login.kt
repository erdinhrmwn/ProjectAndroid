package com.example.projectandroid1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.projectandroid1.Fragment.HomeFragment
import com.example.projectandroid1.Helper.UserHelper
import kotlinx.android.synthetic.main.login.*

class Login: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        btnLogin.setOnClickListener {
            if (etEmail.text.toString() == "erdinhermawann@gmail.com" && etPassword.text.toString() == "password"){
                startActivity(Intent(this, Home::class.java))
                UserHelper(this).StatusLogin = true
                finish()
            }else{
                Toast.makeText(this, "Please check your credentials again", Toast.LENGTH_SHORT).show()
            }
        }
        tvRegister.setOnClickListener { startActivity(Intent(this, Register::class.java)) }
    }
}