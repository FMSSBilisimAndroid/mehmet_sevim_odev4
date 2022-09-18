package com.example.mehmet_sevim_odev4.data.remote

import com.example.mehmet_sevim_odev4.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PlanetsApi {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: PlanetsApiService by lazy {
        retrofit.create(PlanetsApiService::class.java)
    }
}