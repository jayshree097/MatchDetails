package com.example.matchdetails.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.matchdetails.model.TeamList
import com.example.matchdetails.retrofitApi.APIInterface
import com.example.matchdetails.retrofitApi.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamViewModel: ViewModel() {

    var matchDataList= MutableLiveData<TeamList>()


    fun getApiData(){
        val retrofitService= ApiClient.getRetrofitInstance().create(APIInterface::class.java)
        retrofitService.getTeamDetails().enqueue(object : Callback<TeamList> {
            override fun onResponse(
                call: Call<TeamList>,
                response: Response<TeamList>
            ) {

                matchDataList.value=response.body()
                Log.d("MYTAG", "onTeamResponse: "+response.body().toString())
            }

            override fun onFailure(call: Call<TeamList>, t: Throwable) {

                Log.d("MYTAG", "onTeamFailure: "+t.toString())
            }

        })
    }
}