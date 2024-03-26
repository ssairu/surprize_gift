package com.example.surprize_gift.data.repository

import com.example.surprize_gift.data.api.IdeasNetworkService
import com.example.surprize_gift.data.model.Idea

class TopIdeasRepository(private val networkService: IdeasNetworkService) {

//    fun getAllGifts() = networkService.getAllGifts()
    fun getAllIdeas() = mutableListOf<Idea>(
    Idea("0", "Идея 1", "Попробуйте узнать что любит ваш, близкий человек.."),
    Idea("1", "Идея 2", "Удивите себя и близких подарком с неизвестным содержимым"),
    Idea("2", "Идея 3", "Выбрать что-то для вечеринок или семейных посиделок"),
    Idea("3", "Идея 4", "Кулинарная книга с рецептами от любимого шеф-повара"),
)
}