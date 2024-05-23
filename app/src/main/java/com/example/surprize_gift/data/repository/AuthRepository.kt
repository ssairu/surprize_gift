package com.example.surprize_gift.data.repository


import com.vk.id.AccessToken
import com.vk.id.VKIDUser


object AuthRepository {

    private var auth_info: AccessToken = AccessToken("", 0, 0, VKIDUser("Archy", ""))


    fun setAuthInfo(authInfo: AccessToken){
        this.auth_info = authInfo
    }
    fun tryAuth() = auth_info
}