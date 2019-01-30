package com.example.autapplication.model.api


import com.example.autapplication.model.response.Work
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("get_problems")
    fun getAllWorks(): Call<List<Work>>

}