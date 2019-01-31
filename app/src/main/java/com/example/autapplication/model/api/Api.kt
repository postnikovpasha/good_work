package com.example.autapplication.model.api

import com.example.autapplication.model.response.ServerResponse
import com.example.autapplication.model.response.Work
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*

interface Api {

    @GET("get_problems")
    fun getAllWorks(): Call<List<Work>>

    @GET("create_task")
    fun sendWork(@Query("title") problem_title: String,
                 @Query("description") problem_description: String,
                 @Query("customer") customer: String,
                 @Query("coins") coins: String): Call<ServerResponse>

    @GET("user")
    fun getCoins(@Query("login") login: String): Call<ServerResponse>

}