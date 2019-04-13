package com.example.projectandroid1.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectandroid1.Helper.UserHelper
import com.example.projectandroid1.R
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment : Fragment() {
    companion object {
        fun getInstance(): ProfileFragment = ProfileFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name_profile.text = "Hello, " + UserHelper(view.context).Name
    }
}