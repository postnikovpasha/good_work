package com.example.autapplication.works

import android.content.Intent
import android.util.Log
import com.example.autapplication.App
import com.example.autapplication.AuthActivity
import com.example.autapplication.model.response.SignInResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class SignInPresenter {

    private var view: SignInView? = null

    fun bindView(view: SignInView) {
        this.view = view
    }

    fun unbindView() {
        view = null
    }

    fun signIn(login: String, password: String) {
        if (checkCredential(login, password)) {
            App.api
                .signIn(login,password)
                .enqueue(object : Callback<SignInResponse> {
                    override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                        Log.e("asd", t.message)
                        view?.showMessage("Error: Unable connect to server")
                    }

                    override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {
                        val auth =  response.body()?.auth

                        when(auth) {
                            "ok" -> view?.navigateToHomeScreen()
                            "bad" -> view?.showMessage("Login or password is incorrect")
                            "bad_password" -> view?.showMessage("Login or password is incorrect")
                        }
                    }

                })
        } else {
            view?.showMessage("Values must not be empty")
        }

    }

    private fun checkCredential(login: String, password: String): Boolean =
        login.isNotEmpty() && password.isNotEmpty()
}