package com.example.autapplication.OtherActivityAndFragments

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.autapplication.Model.Response.ServerResponse
import com.example.autapplication.Model.Response.Work
import com.example.autapplication.Works.HomeActivity
import kotlinx.android.synthetic.main.activity_add.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.autapplication.R


class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val arg = intent.extras ?: return
        val customer: String = arg.getString("customer")


        btnBack.setOnClickListener {
            finish()
        }


        btnAdd.setOnClickListener {
            val work: Work = Work(
                problem_title = titleEditText.text.toString(),
                problem_description = descriptionEditText.text.toString(),
                customer = customer,
                coins = coinsEditText.text.toString())

            if(checkItem(work.problem_title, work.problem_description, work.coins)) {

                App.api
                    .sendWork(work.problem_title, work.problem_description, work.customer, work.coins)
                    .enqueue(object : Callback<ServerResponse> {
                        override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                            showError("Not sent")
                            Handler().postDelayed({
                                val intent = Intent(this@AddActivity, HomeActivity::class.java)
                                    .putExtra("customer",customer)
                                startActivity(intent)},200)
                        }

                        override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
                            Handler().postDelayed({
                                val intent = Intent(this@AddActivity, HomeActivity::class.java)
                                    .putExtra("customer",customer)
                                startActivity(intent)},200)
                        }
                    })
            }else{
                showError("Values must not be empty")
            }

           //it.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale))

            val scale = AnimationUtils.loadAnimation(this, R.anim.scale)
            it.startAnimation(scale)

        }
    }

    fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun checkItem(problem_title: String, problem_description: String, coins: String): Boolean =
        problem_title.isNotEmpty() && problem_description.isNotEmpty() && coins.isNotEmpty()

}
