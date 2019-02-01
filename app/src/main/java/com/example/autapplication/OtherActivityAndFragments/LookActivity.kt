package com.example.autapplication.OtherActivityAndFragments

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.example.autapplication.Works.HomeActivity
import kotlinx.android.synthetic.main.activity_look.*
import com.example.autapplication.R
import com.example.autapplication.Model.Response.ServerResponse
import com.example.autapplication.Model.Response.Work
import kotlinx.android.synthetic.main.activity_add.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_look)


        val arguments = intent.extras ?: return

        titleTextView.text = arguments.getString("title")
        descriptionTextView.text = arguments.getString("description")
        coinsTextView.text = arguments.getString("coins")
        val customer = arguments.getString("work_customer")
        val login = arguments.getString("login_customer")

        if(customer!= login)
            btnDone.visibility = View.GONE

        btnBack2.setOnClickListener {
            finish()
        }

        btnDone.setOnClickListener {
            App.api
                .decideWork(customer, titleTextView.text.toString())
                .enqueue(object : Callback<ServerResponse> {
                    override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                        Toast.makeText(this@LookActivity, "Not done",Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {

                    }
                })

            doneImageView.animate()
                .scaleX(1F)
                .scaleY(1F)
                .setDuration(500)
                .start()


            Handler().postDelayed({
                val intent = Intent(this, HomeActivity::class.java)
                    .putExtra("customer",customer)
                //Toast.makeText(this,customer,Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }, 500)
        }


    }
}
