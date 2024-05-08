package com.example.surprize_gift.gift.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.surprize_gift.gift.network.TopGiftsRepository
import com.example.surprize_gift.databinding.FragmentMainBinding
import com.example.surprize_gift.gift.GiftsViewModel
import com.example.surprize_gift.gift.GiftsViewModelFactory
import com.example.surprize_gift.gift.network.giftService

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    private val viewModel: GiftsViewModel =
        ViewModelProvider(
            this,
            GiftsViewModelFactory(TopGiftsRepository(giftService()))
        ).get(GiftsViewModel::class.java)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(view?.context, 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position){
                    0 -> 2
                    else ->  1
                }
            }
        }

        val adapter = GiftsAdapter()

        binding.rvIdeas.layoutManager = layoutManager
        binding.rvIdeas.adapter = adapter

        viewModel.giftList.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.setGiftList(it)
            }
        }

    }


}