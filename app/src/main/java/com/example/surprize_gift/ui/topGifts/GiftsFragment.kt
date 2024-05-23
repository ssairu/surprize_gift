package com.example.surprize_gift.ui.topGifts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.surprize_gift.data.api.GiftService
import com.example.surprize_gift.data.api.giftService
import com.example.surprize_gift.data.repository.TopGiftsRepository
import com.example.surprize_gift.databinding.FragmentMainBinding

class GiftsFragment : Fragment() {

    companion object {
        fun newInstance() = GiftsFragment()
    }

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: GiftsViewModel

    private val TAG = "GiftFrag"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        viewModel =
            ViewModelProvider(
                this,
                GiftsViewModelFactory(TopGiftsRepository(giftService()))
            ).get(GiftsViewModel::class.java)
        setupRecyclerView()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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