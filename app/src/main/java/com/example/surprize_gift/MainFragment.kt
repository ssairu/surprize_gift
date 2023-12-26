package com.example.surprize_gift

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surprize_gift.databinding.FragmentMainBinding

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

        val starterList: MutableList<Idea> = mutableListOf(
            Idea(0, "Идея 1", "Попробуйте узнать что любит ваш, близкий человек.."),
            Idea(1, "Идея 2", "Удивите себя и близких подарком с неизвестным содержимым"),
            Idea(2, "Идея 3", "Выбрать что-то для вечеринок или семейных посиделок"),
            Idea(3, "Идея 4", "Кулинарная книга с рецептами от любимого шеф-повара"),
        )

        binding.rvIdeas.adapter = IdeaAdapter(starterList)
    }
}