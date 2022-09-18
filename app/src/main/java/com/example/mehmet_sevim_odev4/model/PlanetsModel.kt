package com.example.mehmet_sevim_odev4.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlanetsModel(
    val price:Int,
    val id:String,
    val type:String,
    val img_src:String
): Parcelable
