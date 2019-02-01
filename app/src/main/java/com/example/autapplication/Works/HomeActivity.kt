package com.example.autapplication.Works

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.autapplication.OtherActivityAndFragments.HomeFragment
import com.example.autapplication.R
import com.example.autapplication.Coins.ProfileFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        val customer = intent.extras?: return
//
//        val sPref: SharedPreferences = getPreferences(MODE_PRIVATE);
//            sPref.edit().putString("login", customer.toString());
//            sPref.edit().commit();



        val homeFragment = HomeFragment.newInstance()
        openFragment(homeFragment)


        navigation.setOnNavigationItemSelectedListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.container)

            when (it.itemId) {
                R.id.action_search -> {
                    if (fragment !is HomeFragment) {
                        val homeFragment = HomeFragment.newInstance()
                        openFragment(homeFragment)
                    }

                    true
                }

                R.id.action_settings -> {
                    if (fragment !is ProfileFragment) {
                        val setFragment = ProfileFragment.newInstance()
                        openFragment(setFragment)
                    }

                    true
                }

                else -> false
            }
        }

        supportFragmentManager.addOnBackStackChangedListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.container)

            navigation.selectedItemId = when(fragment) {
                is HomeFragment ->  R.id.action_search
                is ProfileFragment -> R.id.action_settings
                else -> -1
            }
        }
    }


    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
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
