package com.example.surprize_gift.data.repository

import com.example.surprize_gift.data.api.GiftCardsNetworkService

class TopGiftsRepository(private val networkService: GiftCardsNetworkService) {

    fun getTopGifts(country: String) = networkService.getAllGifts()
}