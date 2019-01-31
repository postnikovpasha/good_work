package com.example.autapplication.works

import android.util.Log
import com.example.autapplication.App
import com.example.autapplication.model.response.ServerResponse
import com.example.autapplication.model.response.Work
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfilePresenter{
    private var view: WorksView? = null

    fun bindView(view: WorksView) {
        this.view = view
        updateCoins()
    }

    private fun updateCoins() {
        App.api
            .getCoins("user")
            .enqueue(object : Callback<ServerResponse> {

                override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                    Log.e("asd", t.message)
                    view?.showMessage("Error: Unable connect to server")


                }

                override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
                    val works = response.body()

                    if (works != null) {
                        view?.showCoins(works)
                    }
                }
            })
    }
}