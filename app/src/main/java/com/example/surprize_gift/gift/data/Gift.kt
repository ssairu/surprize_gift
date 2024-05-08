package com.example.surprize_gift.gift.data

import com.google.gson.annotations.SerializedName

data class Gift(
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
)