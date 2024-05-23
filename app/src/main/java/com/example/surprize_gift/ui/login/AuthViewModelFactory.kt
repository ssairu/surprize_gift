package com.example.surprize_gift.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.surprize_gift.data.repository.AuthRepository
import com.example.surprize_gift.data.repository.TopGiftsRepository
import com.vk.id.VKID

class AuthViewModelFactory(private val repository: AuthRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
                AuthViewModel(repository) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
}