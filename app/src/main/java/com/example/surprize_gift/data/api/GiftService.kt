package com.example.surprize_gift.data.api

import com.example.surprize_gift.data.model.TopGiftsResponse
import com.example.surprize_gift.utils.AppConstant.GIFTS_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GiftService{
    @GET("/api/gifts")
    suspend fun getAllGifts(): TopGiftsResponse

}

fun giftService(): GiftService {
    return Retrofit.Builder()
        .baseUrl(GIFTS_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GiftService::class.java)
}