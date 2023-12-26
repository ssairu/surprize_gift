package com.example.surprize_gift

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.example.surprize_gift.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var profile: AppCompatImageView
    private lateinit var homeButton : AppCompatImageView
    private val tagsFragment = arrayListOf("HOME_FRAG", "SETTINGS_FRAG", "GIFT_FRAG", "LOGIN_FRAG", "REGISTER_FRAG")
    private var page = "HOME_FRAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState != null && savedInstanceState.getString("PAGE")!! != "") {
            page = savedInstanceState.getString("PAGE")!!
        }
        runFragByTag(page)

        profile = findViewById(R.id.account_header)
        profile.setOnClickListener {
            toLogin()
        }

        homeButton = findViewById(R.id.nav_home)
        homeButton.setOnClickListener{
            toHome()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("PAGE", whichFrag(tagsFragment))
    }


    private fun runFragByTag(tag: String){
        when (tag){
            "HOME_FRAG" -> toHome()
            "LOGIN_FRAG" -> toLogin()
            else -> toLogin()
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun toLogin(){
        binding.navHome.setImageDrawable(resources.getDrawable(R.drawable.icon_home))
        binding.navGift.setImageDrawable(resources.getDrawable(R.drawable.icon_present))
        binding.navSettings.setImageDrawable(resources.getDrawable(R.drawable.icon_settings_active))

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragment, LoginFragment(), "LOGIN_FRAG")
            commit()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun toHome(){
        binding.navHome.setImageDrawable(resources.getDrawable(R.drawable.icon_home_active))
        binding.navGift.setImageDrawable(resources.getDrawable(R.drawable.icon_present))
        binding.navSettings.setImageDrawable(resources.getDrawable(R.drawable.icon_settings))

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragment, MainFragment.newInstance(), "HOME_FRAG")
            commit()
        }
    }




    private fun whichFrag(tags: ArrayList<String>): String{
        for (tag in tags) {
            if (isFragActive(tag)){
                return tag
            }
        }

        return ""
    }

    private fun isFragActive(tag: String): Boolean{
        val myFragment = supportFragmentManager.findFragmentByTag(tag)
        if (myFragment?.isVisible == true) {
            return true
        }
        return false
    }

}



