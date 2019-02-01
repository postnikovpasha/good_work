package com.example.autapplication.Model.Api

import com.example.autapplication.Model.Response.CoinsResponse
import com.example.autapplication.Model.Response.ServerResponse
import com.example.autapplication.Model.Response.SignInResponse
import com.example.autapplication.Model.Response.Work
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("get_problems")
    fun getAllWorks(): Call<List<Work>>

    @GET("create_task")
    fun sendWork(@Query("title") problem_title: String,
                 @Query("description") problem_description: String,
                 @Query("customer") customer: String,
                 @Query("coins") coins: String): Call<ServerResponse>
    @GET("decide_task")
    fun decideWork(@Query("extend") customer: String,
                   @Query("problem_title") problem_title: String): Call<ServerResponse>

    @GET("user")
    fun getCoins(@Query("login") login: String): Call<CoinsResponse>

    @GET("login")
    fun signIn(@Query("login") login: String,
               @Query("password") password: String
    ): Call<SignInResponse>

}