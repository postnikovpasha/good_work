package com.example.autapplication

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val songsFragment = HomeFragment.newInstance()
        openFragment(songsFragment)


        navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_search-> {

                    val songsFragment = HomeFragment.newInstance()
                    openFragment(songsFragment)
//                    val intent = Intent(this, HomeActivity::class.java)
//                    startActivity(intent)
                  true
                }
                R.id.action_settings -> {
                    val artistsFragment = SetFragment.newInstance()
                    openFragment(artistsFragment)
//                    val intent = Intent(this, SetActivity::class.java)
//                    startActivity(intent)
                    true
                }else -> false
            }
        }


    }
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
