package com.example.projectandroid1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.register.*

class Register : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        mAuth = FirebaseAuth.getInstance()

        btnRegister.setOnClickListener {
            if (etUsernameReg.text.toString().isEmpty() || etEmailReg.text.toString().isEmpty() ||
                etPasswordReg.text.toString().isEmpty() || etConfirmPasswordReg.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Please check your credentials again", Toast.LENGTH_SHORT).show()
            } else {
                if (etPasswordReg.text.toString() == etConfirmPasswordReg.text.toString()) {
                    registerWithFirebase(etEmailReg.text.toString(), etPasswordReg.text.toString())
                } else {

                    Toast.makeText(this, "Please check your credentials again", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun registerWithFirebase(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("REGISTER", "Register Success")
                    Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
                    mAuth.signOut()
                    startActivity(Intent(this, Login::class.java))
                    finish()
                } else {
                    Log.w("REGISTER", "Register Failed", task.exception)
                    Toast.makeText(this, "Register Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }
}