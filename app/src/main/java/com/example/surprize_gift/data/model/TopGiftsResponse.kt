package com.example.surprize_gift.data.model

import com.google.gson.annotations.SerializedName

data class TopGiftsResponse(
    @SerializedName("gifts")
    val gifts: List<Gift>,
)
