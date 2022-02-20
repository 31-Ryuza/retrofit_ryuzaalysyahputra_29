package com.example.retrofit_ryuzaalysyahputra_29.api

import com.example.retrofit_ryuzaalysyahputra_29.api.model.IndonesiaResponse
import com.example.retrofit_ryuzaalysyahputra_29.api.model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("casenumber.json")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("casenumberprovince.json")
    fun getProvince(): Call<ArrayList<ProvinceResponse>>
}