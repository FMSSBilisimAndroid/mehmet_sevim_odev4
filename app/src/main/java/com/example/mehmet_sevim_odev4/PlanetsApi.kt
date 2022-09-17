package com.example.mehmet_sevim_odev4

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PlanetsApi {
    private const val BASE_URL = "https://mars.udacity.com/"
    val retrofit = Retrofit.Builder()
        // .addConverterFactory(ScalarsConverterFactory.create()) // String response
        // .addConverterFactory(MoshiConverterFactory.create(moshi)) // Convert JSON
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: PlanetsApiService by lazy {
        retrofit.create(PlanetsApiService::class.java)
    }
}