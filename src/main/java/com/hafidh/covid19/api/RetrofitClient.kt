package com.hafidh.covid19.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.kawalcorona.com/"
    val Instance : Api by lazy {
        val Retrofit :Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        Retrofit.create(Api::class.java);
    }
}