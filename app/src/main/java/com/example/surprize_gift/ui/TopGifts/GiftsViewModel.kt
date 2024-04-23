package com.example.surprize_gift.ui.TopGifts


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.surprize_gift.data.model.GiftCard
import com.example.surprize_gift.data.model.TopGiftsResponse
import com.example.surprize_gift.data.repository.TopGiftsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GiftsViewModel(private val repository: TopGiftsRepository) : ViewModel() {

    val giftList = MutableLiveData<List<GiftCard>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllGifts() {
//        giftList.postValue(repository.getAllGifts())
        val response = repository.getAllGifts()
        response.enqueue(object : Callback<TopGiftsResponse> {
            override fun onResponse(call: Call<TopGiftsResponse>, response: Response<TopGiftsResponse>) {
                giftList.postValue(response.body()?.gifts)
                print(response.body()?.gifts)
            }

            override fun onFailure(call: Call<TopGiftsResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}