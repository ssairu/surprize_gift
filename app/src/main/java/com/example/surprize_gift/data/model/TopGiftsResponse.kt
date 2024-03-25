package com.example.surprize_gift.data.model

import com.google.gson.annotations.SerializedName

data class TopGiftsResponse(
    @SerializedName("status")
    val status: String = "",
    @SerializedName("totalResults")
    val totalResults: Int = 0,
    @SerializedName("articles")
    val articles: List<GiftCard> = ArrayList(),
)
