package com.example.surprize_gift.gift


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surprize_gift.gift.data.Gift
import com.example.surprize_gift.gift.network.TopGiftsRepository
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.launch


data class GiftUI(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val title: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("category")
    val category: String = "",
    @SerializedName("price")
    val price: String = "",
    val type: Enum  ()
)
class GiftsViewModel(
    private val repository: TopGiftsRepository
) : ViewModel() {

    private val _giftList = MutableLiveData<List<GiftUI>>()
    val giftList: LiveData<List<GiftUI>>
        get() = _giftList

    init {
        viewModelScope.launch {
            _giftList.value = repository.getAllGifts().gifts.map {
                mapper
            }
        }
    }
}