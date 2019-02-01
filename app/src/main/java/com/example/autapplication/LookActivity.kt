package com.example.autapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.example.autapplication.works.HomeActivity
import kotlinx.android.synthetic.main.activity_look.*
import android.view.animation.AccelerateDecelerateInterpolator
import android.support.v4.view.ViewCompat



class LookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_look)

        val arguments = intent.extras ?: return

        titleTextView.text = arguments.getString("title")
        descriptionTextView.text = arguments.getString("description")
        coinsTextView.text = arguments.getString("coins")

        btnDone.setOnClickListener {
            Toast.makeText(this, "Error: Unable connect to server",Toast.LENGTH_SHORT).show()

            doneImageView.animate()
                .scaleX(1F)
                .scaleY(1F)
                .setDuration(500)
                .start()


            Handler().postDelayed({
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }, 500)
        }

    }
}
