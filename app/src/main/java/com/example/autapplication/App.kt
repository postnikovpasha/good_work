package com.example.autapplication

import android.app.Application
import com.example.autapplication.model.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        val api = Retrofit.Builder()
            .baseUrl("http://104.211.23.214:1488")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()
            .create(Api::class.java)
    }

    override fun onCreate() {
        super.onCreate()
    }

}