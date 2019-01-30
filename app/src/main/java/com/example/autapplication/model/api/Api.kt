package com.example.autapplication.model.api

import com.example.autapplication.model.response.ServerResponse
import com.example.autapplication.model.response.Work
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("get_problems")
    fun getAllWorks(): Call<List<Work>>

    @POST("login?customer")
    fun sendWork(@Body work: Work): Call<ServerResponse>

}