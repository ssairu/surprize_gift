package com.example.surprize_gift.data.model

import com.google.gson.annotations.SerializedName

data class GiftCard(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val title: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("category")
    val category: String = "",
    @SerializedName("price")
    val price: String = "",
//    @SerializedName("url")
//    val url: String = "",
//    @SerializedName("urlToImage")
//    val imageUrl: String = "",
)