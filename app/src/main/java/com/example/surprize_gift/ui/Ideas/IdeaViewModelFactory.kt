package com.example.surprize_gift.ui.Ideas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.surprize_gift.data.repository.TopIdeasRepository

class IdeaViewModelFactory(private val repository: TopIdeasRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(IdeaViewModel::class.java)) {
            IdeaViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}