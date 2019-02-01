package com.example.autapplication.Coins

interface CoinsView {
    fun showCoins(coins: Int)
    fun showMessage(message: String)
    fun showCustomer(login: String)
}