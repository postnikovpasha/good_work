package com.example.autapplication.works

import android.content.Intent

interface SignInView {
    fun showMessage(message: String)
    fun navigateToHomeScreen()
}