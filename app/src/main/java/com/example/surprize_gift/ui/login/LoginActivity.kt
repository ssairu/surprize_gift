package com.example.surprize_gift.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.surprize_gift.R
import com.example.surprize_gift.data.repository.AuthRepository
import com.example.surprize_gift.databinding.ActivityLoginBinding
import com.example.surprize_gift.ui.topGifts.GiftsViewModel
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vkidButton.setCallbacks(
            onAuth = { token -> AuthRepository.setAuthInfo(token) },
            onFail = { fail ->
                when (fail) {
                    is VKIDAuthFail.Canceled -> TODO()
                    is VKIDAuthFail.FailedApiCall -> TODO()
                    is VKIDAuthFail.FailedOAuthState -> TODO()
                    is VKIDAuthFail.FailedRedirectActivity -> TODO()
                    is VKIDAuthFail.NoBrowserAvailable -> TODO()
                    else -> TODO()
                }
            }
        )
    }
}