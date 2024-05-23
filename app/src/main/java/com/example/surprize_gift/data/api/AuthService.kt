package com.example.surprize_gift.data.api

import com.example.surprize_gift.data.model.TopGiftsResponse
import com.example.surprize_gift.utils.AppConstant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AuthService {
    @GET("/api/gifts")
    suspend fun getAllGifts(): TopGiftsResponse

}
