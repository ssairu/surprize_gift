package com.example.surprize_gift.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surprize_gift.data.model.AuthInfo
import com.example.surprize_gift.data.repository.AuthRepository
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail
import kotlinx.coroutines.launch



class AuthViewModel(private val repository: AuthRepository) : ViewModel() {
    private val _authList = MutableLiveData<AuthInfo>()
    val authInfo: LiveData<AuthInfo>
        get() = _authList

    init {
        viewModelScope.launch {
            _authList.value = AuthInfo(repository.tryAuth())
        }
    }
}