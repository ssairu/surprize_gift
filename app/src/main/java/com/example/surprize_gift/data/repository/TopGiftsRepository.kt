package com.example.surprize_gift.data.repository

import com.example.surprize_gift.data.api.GiftService

class TopGiftsRepository(private val networkService: GiftService) {
        suspend fun getAllGifts() = networkService.getAllGifts()
}