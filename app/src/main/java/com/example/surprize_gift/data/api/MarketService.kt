package com.example.surprize_gift.data.api

import com.example.surprize_gift.utils.AppConstant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarketService {
//    @GET("/api/gifts")
//    suspend fun getAllTools(): MarketResponse

}

fun marketService(): GiftService {
    return Retrofit.Builder()
        .baseUrl(AppConstant.TOOLS_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GiftService::class.java)
}