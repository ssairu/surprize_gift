package com.example.surprize_gift.data.api

import com.example.surprize_gift.data.model.TopGiftsResponse
import com.example.surprize_gift.utils.AppConstant.GIFTS_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GiftCardsNetworkService{
    @GET("api?s=batman")
    fun getAllGifts(): Call<TopGiftsResponse>

    companion object {

        var retrofitService: GiftCardsNetworkService? = null
        fun getInstance(): GiftCardsNetworkService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(GIFTS_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(GiftCardsNetworkService::class.java)
            }
            return retrofitService!!
        }
    }
}