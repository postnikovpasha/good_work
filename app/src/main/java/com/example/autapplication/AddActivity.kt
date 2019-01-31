package com.example.autapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.autapplication.model.response.ServerResponse
import com.example.autapplication.model.response.Work
import com.example.autapplication.works.HomeActivity
import kotlinx.android.synthetic.main.activity_add.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnAdd.setOnClickListener {
            val work: Work = Work(
                problem_title = titleEditText.text.toString(),
                problem_description = descriptionEditText.text.toString(),
                customer = "",
                coins = coinsEditText.text.toString()
            )
            App.api
                .sendWork(work)
                .enqueue(object : Callback<ServerResponse> {
                    override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                        showError(t.message ?: "Unknown error")
                    }

                    override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
                        showError("good")
                    }
                })


            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
