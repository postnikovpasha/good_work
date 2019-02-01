package com.example.autapplication.works

import android.util.Log
import com.example.autapplication.App
import com.example.autapplication.model.response.CoinsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfilePresenter{
    private var view: CoinsView? = null

    fun bindView(view: CoinsView) {
        this.view = view
    }

    fun onViewShown() {
        updateCoins()
    }

    private fun updateCoins() {
        App.api
            .getCoins("user")
            .enqueue(object : Callback<CoinsResponse> {

                override fun onFailure(call: Call<CoinsResponse>, t: Throwable) {
                    Log.e("asd", t.message)
                    view?.showMessage("Error: Unable connect to server")
                }

                override fun onResponse(call: Call<CoinsResponse>, response: Response<CoinsResponse>) {
                    onCoinUpdateResponse(response)
                }
            })
    }

    private fun onCoinUpdateResponse(response: Response<CoinsResponse>) {
        val works = response.body()

        if (works != null) {
            view?.showCoins(works.coins)
        }
    }
}