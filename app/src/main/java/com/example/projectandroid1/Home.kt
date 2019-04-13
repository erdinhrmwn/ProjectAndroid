package com.example.projectandroid1

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.projectandroid1.Fragment.*
import com.example.projectandroid1.Helper.UserHelper
import kotlinx.android.synthetic.main.home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        if (!UserHelper(this).StatusLogin) {
            startActivity(Intent(this, Login::class.java))
            finish()
        }
        val menu: Menu = navigation.menu
        selectedMenu(menu.getItem(0))
        navigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            selectedMenu(item)
            true
        }
    }

    private fun selectedMenu(item: MenuItem) {
        when (item.itemId) {
            R.id.home -> selectedFragment(HomeFragment.getInstance())
            R.id.search -> selectedFragment(SearchFragment.getInstance())
            R.id.add -> selectedFragment(AddFragment.getInstance())
            R.id.message -> selectedFragment(MessageFragment.getInstance())
            R.id.profile -> selectedFragment(ProfileFragment.getInstance())
        }
    }

    private fun selectedFragment(fragment: Fragment) {
        val transaction: FragmentTransaction? = supportFragmentManager.beginTransaction()
        transaction?.replace(R.id.rootFragment, fragment)
        transaction?.commit()
    }
}