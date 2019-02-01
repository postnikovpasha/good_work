package com.example.autapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.example.autapplication.works.HomeActivity
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        btnAuth.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()


            if(checkLogin(login) && checkPassword(password)) {
                val scale = AnimationUtils.loadAnimation(this, R.anim.scale)
                it.startAnimation(scale)

                Handler().postDelayed({
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)},
                    200)


            } else {
                val scale = AnimationUtils.loadAnimation(this, R.anim.scale)
                it.startAnimation(scale)
                Toast.makeText(this, "Login or password is incorrect",Toast.LENGTH_SHORT).show()
            }
        }
btnSignUp.setOnClickListener{
    val scale = AnimationUtils.loadAnimation(this, R.anim.scale)
    it.startAnimation(scale)
}
    }

    private fun checkLogin (login: String): Boolean {
        return login == "user"
    }

    private fun checkPassword(password: String): Boolean{
        return password == "12345"
    }

    override fun onResume() {
        super.onResume()


    }
}
