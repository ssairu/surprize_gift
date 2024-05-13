package com.example.surprize_gift

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surprize_gift.databinding.FragmentMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IdeasService {
    @GET("/api/ideas")
    suspend fun getIdeas(): List<Idea>
}

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(view.context)
        binding.rvIdeas.layoutManager = layoutManager


        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.2:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IdeasService::class.java)
        val apiService : IdeasService = retrofit
        runBlocking {
            val response = withContext(Dispatchers.IO){
                apiService.getIdeas()
            }
            binding.rvIdeas.adapter = IdeaAdapter(response.toMutableList())
        }
        /*val starterList: MutableList<Idea> = mutableListOf(
            Idea(0, "Идея 1", "Попробуйте узнать что любит ваш, близкий человек.."),
            Idea(1, "Идея 2", "Удивите себя и близких подарком с неизвестным содержимым"),
            Idea(2, "Идея 3", "Выбрать что-то для вечеринок или семейных посиделок"),
            Idea(3, "Идея 4", "Кулинарная книга с рецептами от любимого шеф-повара"),
        )*/


//        binding.rvIdeas.adapter = IdeaAdapter(starterList)
    }
}