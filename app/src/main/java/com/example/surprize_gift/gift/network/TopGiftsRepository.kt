package com.example.surprize_gift.gift.network

class TopGiftsRepository(private val networkService: GiftService) {
    suspend fun getAllGifts() = networkService.getAllGifts()

}