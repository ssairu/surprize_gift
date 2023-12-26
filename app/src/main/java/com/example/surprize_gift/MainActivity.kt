package com.example.surprize_gift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.surprize_gift.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment, MainFragment.newInstance())
            .commit()
    }


}