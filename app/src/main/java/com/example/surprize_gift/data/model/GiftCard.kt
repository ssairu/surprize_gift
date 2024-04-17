package com.example.surprize_gift.data.model

import android.icu.text.CaseMap.Title
import com.google.gson.annotations.SerializedName

data class GiftCard(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val imageUrl: String = "",
)