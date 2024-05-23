package com.example.surprize_gift.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.ViewModelProvider
import com.example.surprize_gift.GiftFragment
import com.example.surprize_gift.R
import com.example.surprize_gift.data.api.giftService
import com.example.surprize_gift.data.repository.AuthRepository
import com.example.surprize_gift.data.repository.TopGiftsRepository
import com.example.surprize_gift.databinding.ActivityMainBinding
import com.example.surprize_gift.ui.login.AuthViewModel
import com.example.surprize_gift.ui.login.AuthViewModelFactory
import com.example.surprize_gift.ui.login.LoginActivity
import com.example.surprize_gift.ui.topGifts.GiftsFragment
import com.example.surprize_gift.ui.topGifts.GiftsViewModel
import com.example.surprize_gift.ui.topGifts.GiftsViewModelFactory
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var profile: AppCompatImageView
    private lateinit var viewModel: AuthViewModel
    private lateinit var homeButton: AppCompatImageView
    private val tagsFragment = arrayListOf("HOME_FRAG", "SETTINGS_FRAG", "GIFT_FRAG", "LOGIN_FRAG")
    private var page = "HOME_FRAG"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState != null && savedInstanceState.getString("PAGE")!! != "") {
            page = savedInstanceState.getString("PAGE")!!
        }
        runFragByTag(page)
        setGOTOfrag()

        if (AuthRepository.tryAuth().userData.photo100 != null) {
            Picasso.get().load(AuthRepository.tryAuth().userData.photo100).into(binding.accountHeader)
            binding.logoHeader.text = AuthRepository.tryAuth().userData.firstName
        }

    }

    private fun setGOTOfrag() {
        profile = findViewById(R.id.account_header)
        profile.setOnClickListener {
            toLogin()
        }

        binding.navSettings.setOnClickListener {
            toLogin()
        }

        binding.logoHeader.setOnClickListener {
            toHome()
        }

        binding.logoHeader.setOnClickListener {
            toHome()
        }

        binding.navGift.setOnClickListener {
            toHome()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("PAGE", whichFrag(tagsFragment))
    }


    private fun runFragByTag(tag: String) {
        when (tag) {
            "HOME_FRAG" -> toHome()
            "LOGIN_FRAG" -> toLogin()
            "GIFT_FRAG" -> toGift()
            else -> toLogin()
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    fun toLogin() {
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun toHome() {
        binding.navCalendar.setImageDrawable(resources.getDrawable(R.drawable.icon_calendar))
        binding.navIdea.setImageDrawable(resources.getDrawable(R.drawable.icon_idea))
        binding.navGift.setImageDrawable(resources.getDrawable(R.drawable.icon_present_active))
        binding.navSettings.setImageDrawable(resources.getDrawable(R.drawable.icon_settings))

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragment, GiftsFragment.newInstance(), "HOME_FRAG")
            commit()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun toGift() {
        binding.navCalendar.setImageDrawable(resources.getDrawable(R.drawable.icon_calendar))
        binding.navIdea.setImageDrawable(resources.getDrawable(R.drawable.icon_idea))
        binding.navGift.setImageDrawable(resources.getDrawable(R.drawable.icon_present_active))
        binding.navSettings.setImageDrawable(resources.getDrawable(R.drawable.icon_settings))

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragment, GiftFragment.newInstance(), "GIFT_FRAG")
            commit()
        }
    }


    private fun whichFrag(tags: ArrayList<String>): String {
        for (tag in tags) {
            if (isFragActive(tag)) {
                return tag
            }
        }

        return ""
    }

    private fun isFragActive(tag: String): Boolean {
        val myFragment = supportFragmentManager.findFragmentByTag(tag)
        if (myFragment?.isVisible == true) {
            return true
        }
        return false
    }

}



