package com.example.autapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login or password is incorrect",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkLogin (login: String): Boolean {
        return login == "user"
    }

    private fun checkPassword(password: String): Boolean{
        return password == "12345"
    }
}
