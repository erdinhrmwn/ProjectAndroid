package com.example.projectandroid1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.projectandroid1.Fragment.HomeFragment
import com.example.projectandroid1.Helper.UserHelper
import kotlinx.android.synthetic.main.register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        btnRegister.setOnClickListener {
            if (etUsernameReg.text.toString() == "" && etEmailReg.text.toString() == "" &&
                etPasswordReg.text.toString() == "" && etConfirmPasswordReg.text.toString() == ""
            ) {
                Toast.makeText(this, "Please check your credentials again", Toast.LENGTH_SHORT).show()
            } else {
                if (etPasswordReg.text.toString() == etConfirmPasswordReg.text.toString()) {
                    startActivity(Intent(this, Home::class.java))
                    UserHelper(this).StatusLogin = true
                    finish()
                } else {
                    Toast.makeText(this, "Please check your credentials again", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}