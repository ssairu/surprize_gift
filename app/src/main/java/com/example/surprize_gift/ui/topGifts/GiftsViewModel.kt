package com.example.surprize_gift.ui.topGifts


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surprize_gift.data.model.Gift
import com.example.surprize_gift.data.model.TopGiftsResponse
import com.example.surprize_gift.data.repository.TopGiftsRepository
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
//    val type: Enum ()
)

class GiftsViewModel(
    private val repository: TopGiftsRepository
) : ViewModel() {

    private val _giftList = MutableLiveData<List<Gift>>()
    val giftList: LiveData<List<Gift>>
        get() = _giftList

    init {
        viewModelScope.launch {
            _giftList.value = repository.getAllGifts().gifts//.map {
//                mapper
//            }
        }
    }
}