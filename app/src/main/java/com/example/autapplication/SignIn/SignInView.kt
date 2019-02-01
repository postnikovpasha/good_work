package com.example.autapplication.SignIn

import android.content.Intent

interface SignInView {
    fun showMessage(message: String)
    fun navigateToHomeScreen()
}