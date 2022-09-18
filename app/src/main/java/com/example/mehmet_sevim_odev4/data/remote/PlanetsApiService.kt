package com.example.mehmet_sevim_odev4.data.remote

import com.example.mehmet_sevim_odev4.model.PlanetsModel
import retrofit2.Call
import retrofit2.http.GET

interface PlanetsApiService {
    @GET("realestate")
    fun getProperties(): Call<List<PlanetsModel>>
}