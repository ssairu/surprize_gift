package com.example.surprize_gift.data.model

import com.google.gson.annotations.SerializedName

data class Idea(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("body")
    val body: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val imageUrl: String = "",
)