package com.example.autapplication.Works

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.autapplication.OtherActivityAndFragments.HomeFragment
import com.example.autapplication.R
import com.example.autapplication.Coins.ProfileFragment
import kotlinx.android.synthetic.main.activity_home.*






class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.autapplication.R.layout.activity_home)

        val arg = intent.extras

        val customer: String = arg.getString("customer")

        val homeFragment = HomeFragment.newInstance()
        val bundle = Bundle()
        bundle.putString("customer",customer)
        homeFragment.setArguments(bundle)
        openFragment(homeFragment)


        navigation.setOnNavigationItemSelectedListener {
            val fragment = supportFragmentManager.findFragmentById(com.example.autapplication.R.id.container)

            when (it.itemId) {
                com.example.autapplication.R.id.action_search -> {
                    if (fragment !is HomeFragment) {
                        val homeFragment = HomeFragment.newInstance()
                        val bundle = Bundle()
                        bundle.putString("customer",customer)
                        homeFragment.setArguments(bundle)
                        openFragment(homeFragment)
                    }

                    true
                }

                com.example.autapplication.R.id.action_settings -> {
                    if (fragment !is ProfileFragment) {
                        val setFragment = ProfileFragment.newInstance()
                        val bundle = Bundle()
                        bundle.putString("customer",customer)
                        setFragment.setArguments(bundle)
                        openFragment(setFragment)
                    }

                    true
                }

                else -> false
            }
        }

        supportFragmentManager.addOnBackStackChangedListener {
            val fragment = supportFragmentManager.findFragmentById(com.example.autapplication.R.id.container)

            navigation.selectedItemId = when(fragment) {
                is HomeFragment ->  com.example.autapplication.R.id.action_search
                is ProfileFragment -> com.example.autapplication.R.id.action_settings
                else -> -1
            }
        }
    }


    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(com.example.autapplication.R.id.container, fragment)
                .addToBackStack(null)
                .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}

