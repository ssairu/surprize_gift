package com.example.surprize_gift

import android.app.Application
import com.vk.id.VKID

class MVVMApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        VKID.init(this)
    }
}

