package com.example.autapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.autapplication.App.Companion.api
import com.example.autapplication.works.HomeActivity
import com.example.autapplication.works.SignInPresenter
import com.example.autapplication.works.SignInView
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : AppCompatActivity(), SignInView {


    private val presenter = SignInPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        btnAuth.setOnClickListener {
            val login: String = loginEditText.text.toString()
            val password: String = passwordEditText.text.toString()
            presenter.signIn(login,password)

            val scale = AnimationUtils.loadAnimation(this, R.anim.scale)
            it.startAnimation(scale)

        }

        btnSignUp.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            val scale = AnimationUtils.loadAnimation(this, R.anim.scale)
            it.startAnimation(scale)
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbindView()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun navigateToHomeScreen() {
        finish()
        val intent = Intent(this, HomeActivity::class.java)
            .putExtra("Customer",loginEditText.text.toString())
        startActivity(intent)
    }


}
