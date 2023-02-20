package com.example.matchdetails.retrofitApi
import com.example.matchdetails.model.PlayerList
import com.example.matchdetails.model.ResponseMatchInfo
import com.example.matchdetails.model.TeamList
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("https://demo.sportz.io/nzin01312019187360.json")
    fun getMatchDetails():Call<ResponseMatchInfo>
    @GET("https://demo.sportz.io/nzin01312019187360.json")
    fun getTeamDetails():Call<TeamList>

    @GET("https://demo.sportz.io/nzin01312019187360.json")
    fun getPlayerDetails():Call<PlayerList>

}