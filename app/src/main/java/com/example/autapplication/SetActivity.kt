package com.example.autapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_set.*

class SetActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set)


//        navigation2.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.action_search-> {
//                    val intent = Intent(this, HomeActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
//                R.id.action_settings -> {
//                    val intent = Intent(this, SetActivity::class.java)
//                    startActivity(intent)
//                    true
//                }else -> false
//            }
//        }


    }
}
