package com.example.autapplication.works

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import com.example.autapplication.AddActivity
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
        view?.showProgress()

        App.api
            .getAllWorks()
            .enqueue(object : Callback<List<Work>> {
                override fun onFailure(call: Call<List<Work>>, t: Throwable) {
                    Log.e("asd", t.message)
                    view?.hideProgress()
                    view?.showMessage("Error: Unable connect to server")

                    view?.showWorks(listOf(
                        Work("Vitya","Transfer grandmother (fake)","Transfer grandmother across the road","15"),
                        Work("Andrey","Warm up the car (fake)","Warm up my car. She froze","30"),
                        Work("Pasha","Buy Xiaomi (fake)","Buy xiaomi pleeeeeas", "1000"),
                        Work("Vitya","Raise server (fake)","Again the server fell, please raise","35"),
                        Work("Andrey","Stop (fake)","Vite need to go out","10"),
                        Work("Pasha","Reinstall Windows (fake)","Windows fucked up again", "20"),
                        Work("Vitya","Who has an adapter for the VGA? (fake)","Zazhralsya and bought a new Macbook","35"),
                        Work("Andrey","Android vs IOS (fake)","Android is better, but I have an iphone","10"),
                        Work("Pasha","I want to cft.team (fake)","Take me please", "99999"),
                        Work("Vitya","Ran out of pies (fake)","And I just came","35"),
                        Work("Andrey","When is afterparty? (fake)","do not mind it","10"),
                        Work("Pasha","Give a tour in cft (fake)","Go?", "20")
                    ))

                }

                override fun onResponse(call: Call<List<Work>>, response: Response<List<Work>>) {
                    view?.hideProgress()
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