package com.example.surprize_gift.ui.topGifts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.surprize_gift.data.repository.TopGiftsRepository

class GiftsViewModelFactory(private val repository: TopGiftsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(GiftsViewModel::class.java)) {
            GiftsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}