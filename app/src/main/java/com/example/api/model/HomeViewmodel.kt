package com.example.api.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.api.api.ApiClient
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Response

class HomeViewmodel : ViewModel()
{
    //LiveData = immutalbe    //MutableLiveData

    private var news: MutableLiveData<News> = MutableLiveData()

    fun getArticle(): LiveData<News> = news

    fun loadArticle() {

        var apiClient = ApiClient()

        var apiCall = apiClient.getEverything()

        apiCall.enqueue(object : retrofit2.Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {
              //  txtResult.text = t.toString()
                Log.d("Error>>>>>>",t.toString())
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
             //   txtResult.text = response.body()?.articles?.get(0)?.title.toString()
           // articlelist = response.body()!!.articles

                news.value = response.body()
            }
        })
    }
}