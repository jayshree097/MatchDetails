package com.example.matchdetails.viewModel
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.matchdetails.model.ResponseMatchInfo
import com.example.matchdetails.retrofitApi.APIInterface
import com.example.matchdetails.retrofitApi.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchViewModel:ViewModel() {
    var matchDataList= MutableLiveData<ResponseMatchInfo>()


    fun getApiData(){
        val retrofitService= ApiClient.getRetrofitInstance().create(APIInterface::class.java)
        retrofitService.getMatchDetails().enqueue(object : Callback<ResponseMatchInfo>{
            override fun onResponse(
                call: Call<ResponseMatchInfo>,
                response: Response<ResponseMatchInfo>
            ) {

                matchDataList.value=response.body()
                Log.d("MYTAG", "onResponse: "+response.body().toString())
            }

            override fun onFailure(call: Call<ResponseMatchInfo>, t: Throwable) {

                Log.d("MYTAG", "onFailure: "+t.toString())
            }

        })
    }
}