package com.example.surprize_gift

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.surprize_gift.databinding.SurpriseGiftFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("api/gift/{id}")
    suspend fun getDataById(
        @Path("id") id: Int,
        @Query("category") category: String?,
        @Query("price_range") priceRange: String?,
        @Query("sort_by") sortBy: String?,
        @Query("limit") limit: Int
    ): GiftItem
}

data class GiftItem(
    val id : Int,
    val name : String,
    val description : String,
    val type : String,
    val price : Int
)

class GiftFragment : Fragment() {
    companion object {
        fun newInstance() = GiftFragment()
    }
    private lateinit var binding: SurpriseGiftFragmentBinding
    private var id = 1
    private var category = null
    private var priceRange = null
    private val sortBy = null
    private val limit = 2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SurpriseGiftFragmentBinding.inflate(inflater)
        val retrofit = Retrofit.Builder()
            .baseUrl("192.168.1.2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
        val apiService : ApiService = retrofit
        runBlocking {
            val response = withContext(Dispatchers.IO){
                apiService.getDataById(id, category, priceRange, sortBy, limit)
            }
            binding.textView2.text = response.name
            binding.bodyQ1.text = "${response.description} Теги: ${response.type}"
            binding.textView3.text = "${response.price} рублей"

        }
//        apiService.getDataById(id, category, priceRange, sortBy, limit)



        return binding.root
    }
}