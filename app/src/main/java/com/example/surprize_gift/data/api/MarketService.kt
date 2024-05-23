package com.example.surprize_gift.data.api

import com.example.surprize_gift.data.model.TopGiftsResponse
import com.example.surprize_gift.utils.AppConstant
import com.vk.sdk.api.market.dto.MarketGetResponseDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MarketService {
//    @GET("/market/gifts")
//    suspend fun getAllGifts(): MarketGetResponseDto
}

fun marketService(): GiftService {
    return Retrofit.Builder()
        .baseUrl(AppConstant.TOOLS_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GiftService::class.java)
}