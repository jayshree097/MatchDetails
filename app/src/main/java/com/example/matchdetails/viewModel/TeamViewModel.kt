package com.example.matchdetails.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.matchdetails.TeamResponse
import com.example.matchdetails.model.ResponseMatchInfo
import com.example.matchdetails.retrofitApi.APIInterface
import com.example.matchdetails.retrofitApi.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamViewModel: ViewModel() {

    var matchDataList= MutableLiveData<TeamResponse>()


    fun getApiData(){
        val retrofitService= ApiClient.getRetrofitInstance().create(APIInterface::class.java)
        retrofitService.getTeamDetails().enqueue(object : Callback<TeamResponse> {
            override fun onResponse(
                call: Call<TeamResponse>,
                response: Response<TeamResponse>
            ) {

                matchDataList.value=response.body()
                Log.d("MYTAG", "onResponse: "+response.body().toString())
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {

                Log.d("MYTAG", "onFailure: "+t.toString())
            }

        })
    }
}