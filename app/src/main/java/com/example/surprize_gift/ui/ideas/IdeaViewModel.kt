package com.example.surprize_gift.ui.ideas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.surprize_gift.data.model.Idea
import com.example.surprize_gift.data.repository.TopIdeasRepository

class IdeaViewModel(private val repository: TopIdeasRepository) : ViewModel() {

    val ideaList = MutableLiveData<List<Idea>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {
        ideaList.postValue(repository.getAllIdeas())
//        val response = repository.getAllIdeas()
//        response.enqueue(object : Callback<TopIdeas> {
//            override fun onResponse(call: Call<TopIdeas>, response: Response<TopIdeas>) {
//                ideaList.postValue(response.body()?.ideas)
//            }
//
//            override fun onFailure(call: Call<TopIdeas>, t: Throwable) {
//                errorMessage.postValue(t.message)
//            }
//        })
    }
}