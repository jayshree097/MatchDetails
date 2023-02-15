package com.example.matchdetails.retrofitApi

import com.example.matchdetails.model.ResponseMatchInfo
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("https://demo.sportz.io/nzin01312019187360.json")
    fun getMatchDetails():Call<ResponseMatchInfo>

}