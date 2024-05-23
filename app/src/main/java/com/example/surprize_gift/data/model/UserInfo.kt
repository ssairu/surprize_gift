package com.example.surprize_gift.data.model

import com.google.gson.annotations.SerializedName

data class UserInfo(
    public val firstName: String,
    public val lastName: String,
    public val phone: String? = null,
    public val photo50: String? = null,
    public val photo100: String? = null,
    public val photo200: String? = null,
    public val email: String? = null
)