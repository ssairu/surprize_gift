package com.example.surprize_gift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageView
import com.example.surprize_gift.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var profile: AppCompatImageView
    private lateinit var homeButton : AppCompatImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment, MainFragment.newInstance())
            .commit()

        profile = findViewById(R.id.account_header)
        profile.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_fragment, LoginFragment())
                commit()
            }
        }

        homeButton = findViewById(R.id.nav_home)
        homeButton.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_fragment, MainFragment.newInstance())
                commit()
            }
        }


    }
}