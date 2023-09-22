package io.github.freewebmovement

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API : Callback<Quota?> {
    var quota: Quota? = null
    private var httpClient = OkHttpClient.Builder()
    fun start(username: String, password: String) {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
        val apiService = retrofit.create(
            APIService::class.java
        )
        val quotaCall = apiService.getQuota(username, password)
        quotaCall!!.enqueue(this)
    }

    override fun onResponse(call: Call<Quota?>, response: Response<Quota?>) {
        if (response.isSuccessful) {
            quota = response.body()
        } else {
            println(response.errorBody())
        }
    }

    override fun onFailure(call: Call<Quota?>, t: Throwable) {
        t.printStackTrace()
    }

    companion object {
        var BASE_URL = "https://games.yikuaijiasu.top/"
    }
}