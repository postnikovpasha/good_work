package com.example.autapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_look.*

class LookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_look)

        val arguments = intent.extras ?: return

        titleTextView.text = arguments.getString("title")
        descriptionTextView.text = arguments.getString("description")
        coinsTextView.text = arguments.getString("coins")

    }
}
