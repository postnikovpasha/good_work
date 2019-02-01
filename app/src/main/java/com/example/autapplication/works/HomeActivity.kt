package com.example.autapplication.works

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.autapplication.HomeFragment
import com.example.autapplication.R
import com.example.autapplication.ProfileFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val homeFragment = HomeFragment.newInstance()
        openFragment(homeFragment)


        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_search -> {

                    val homeFragment = HomeFragment.newInstance()
                    openFragment(homeFragment)
                    true
                }
                R.id.action_settings -> {
                    val setFragment = ProfileFragment.newInstance()
                    openFragment(setFragment)
                    true
                }
                else -> false
            }
        }


    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
    }


}
