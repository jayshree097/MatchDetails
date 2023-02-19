package com.example.matchdetails.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.matchdetails.model.PlayerList
import com.example.matchdetails.retrofitApi.APIInterface
import com.example.matchdetails.retrofitApi.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayerViewModel: ViewModel() {
    var playerDataList= MutableLiveData<PlayerList>()



    fun getPlayerApiData(){
        val retrofitService= ApiClient.getRetrofitInstance().create(APIInterface::class.java)
        retrofitService.getPlayerDetails().enqueue(object : Callback<PlayerList> {
            override fun onResponse(
                call: Call<PlayerList>,
                response: Response<PlayerList>
            ) {

                playerDataList.value=response.body()
                Log.d("MYTAG", "onPlayerResponse: "+response.body().toString())
            }

            override fun onFailure(call: Call<PlayerList>, t: Throwable) {

                Log.d("MYTAG", "onPlayerFailure: "+t.toString())
            }

        })
    }
}