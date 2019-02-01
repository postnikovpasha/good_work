package com.example.autapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.autapplication.model.response.ServerResponse
import com.example.autapplication.model.response.Work
import com.example.autapplication.works.HomeActivity
import kotlinx.android.synthetic.main.activity_add.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.support.v7.widget.Toolbar


class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }


        btnAdd.setOnClickListener {
            val work: Work = Work(
                problem_title = titleEditText.text.toString(),
                problem_description = descriptionEditText.text.toString(),
                customer = "user",
                coins = coinsEditText.text.toString()
            )
            App.api
                .sendWork(work.problem_title, work.problem_description, work.customer, work.coins)
                .enqueue(object : Callback<ServerResponse> {
                    override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                        showError(t.message ?: "Unknown error")
                    }

                    override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
                        showError("good")
                    }
                })
           //it.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale))

            val scale = AnimationUtils.loadAnimation(this, R.anim.scale)
            it.startAnimation(scale)

            Handler().postDelayed({
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)},200)


        }
    }

    fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
