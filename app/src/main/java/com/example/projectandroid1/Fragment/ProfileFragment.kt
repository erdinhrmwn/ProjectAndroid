package com.example.projectandroid1.Fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectandroid1.Helper.UserHelper
import com.example.projectandroid1.MainActivity
import com.example.projectandroid1.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment : Fragment() {
    private lateinit var mAuth: FirebaseAuth

    companion object {
        fun getInstance(): ProfileFragment = ProfileFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name_profile.text = "Hello, " + UserHelper(view.context).Name

        mAuth = FirebaseAuth.getInstance()
        logoutBtn.setOnClickListener {
            UserHelper(view.context).StatusLogin = false
            mAuth.signOut()
            startActivity(Intent(view.context, MainActivity::class.java))
        }
    }
}