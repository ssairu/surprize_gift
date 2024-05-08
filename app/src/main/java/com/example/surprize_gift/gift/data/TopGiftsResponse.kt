package com.example.surprize_gift.gift.data

import com.google.gson.annotations.SerializedName

data class TopGiftsResponse(
    @SerializedName("gifts")
    val gifts: List<Gift>,
)
