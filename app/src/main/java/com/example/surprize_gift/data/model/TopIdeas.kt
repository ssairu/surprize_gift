package com.example.surprize_gift.data.model

import com.google.gson.annotations.SerializedName

data class TopIdeas(
    @SerializedName("ideas")
    val ideas: List<Idea> = ArrayList(),
)
