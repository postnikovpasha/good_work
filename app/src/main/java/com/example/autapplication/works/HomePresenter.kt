package com.example.autapplication.works

import android.util.Log
import com.example.autapplication.App
import com.example.autapplication.model.api.Api
import com.example.autapplication.model.response.Work
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter {
    private var view: WorksView? = null

    fun bindView(view: WorksView) {
        this.view = view
        updateWorks()
    }

    private fun updateWorks() {
        App.api
            .getAllWorks()
            .enqueue(object : Callback<List<Work>> {
                override fun onFailure(call: Call<List<Work>>, t: Throwable) {
                    Log.e("asd", t.message)
                }

                override fun onResponse(call: Call<List<Work>>, response: Response<List<Work>>) {
                    val works = response.body()

                    if (works != null) {
                        view?.showWorks(works)
                    }
                }
            })
    }

    fun unbindView() {
        this.view = null
    }
}