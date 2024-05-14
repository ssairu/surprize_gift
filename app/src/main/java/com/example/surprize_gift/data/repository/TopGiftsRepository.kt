package com.example.surprize_gift.data.repository

import com.example.surprize_gift.data.api.GiftCardsNetworkService

class TopGiftsRepository(private val networkService: GiftCardsNetworkService) {

    fun getAllGifts() = networkService.getAllGifts()
//    fun getAllGifts() = mutableListOf<GiftCard>(
//    GiftCard("0", "Идея 1", "Попробуйте узнать что любит ваш, близкий человек.."),
//    GiftCard("1", "Идея 2", "Удивите себя и близких подарком с неизвестным содержимым"),
//    GiftCard("2", "Идея 3", "Выбрать что-то для вечеринок или семейных посиделок"),
//    GiftCard("3", "Идея 4", "Кулинарная книга с рецептами от любимого шеф-повара"),
//    )
}