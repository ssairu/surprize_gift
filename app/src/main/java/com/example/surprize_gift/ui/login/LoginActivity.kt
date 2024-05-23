package com.example.surprize_gift.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.surprize_gift.R
import com.example.surprize_gift.data.repository.AuthRepository
import com.example.surprize_gift.databinding.ActivityLoginBinding
import com.example.surprize_gift.ui.login.uikit.forEachView
import com.example.surprize_gift.ui.login.uikit.getOneTapFailCallback
import com.example.surprize_gift.ui.login.uikit.getOneTapSuccessCallback
import com.example.surprize_gift.ui.topGifts.GiftsViewModel
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail
import com.vk.id.auth.VKIDAuthCallback
import com.vk.id.onetap.xml.OneTap

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findViewById<View>(android.R.id.content).rootView.forEachView(OneTap::class) { widget ->
            widget.setCallbacks(
                onAuth = getOneTapSuccessCallback(this,
                    onToken = {accessToken -> AuthRepository.setAuthInfo(accessToken)}),
                onFail = getOneTapFailCallback(this),
            )
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        VKID.init(this)
//        val vkid = VKID.instance
//        binding.vkidButton.setOnClickListener {
//            vkid.authorize(this@LoginActivity, vkAuthCallback)
//        }
//    }
}