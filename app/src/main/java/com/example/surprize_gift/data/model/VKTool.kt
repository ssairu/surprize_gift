package com.example.surprize_gift.data.model

import com.google.gson.annotations.SerializedName

data class VKTool(
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val owner_id: Int,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("category")
    val category: String = "",
    @SerializedName("price")
    val price: String = "",
)