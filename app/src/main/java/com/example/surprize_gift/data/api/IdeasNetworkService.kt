package com.example.surprize_gift.data.api

import com.example.surprize_gift.data.model.TopIdeas
import com.example.surprize_gift.utils.AppConstant
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IdeasNetworkService {
    @GET("api?s=batman")
    fun getAllGifts(): Call<TopIdeas>

    companion object {

        var retrofitService: IdeasNetworkService? = null
        fun getInstance(): IdeasNetworkService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(AppConstant.IDEAS_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(IdeasNetworkService::class.java)
            }
            return retrofitService!!
        }
    }
}