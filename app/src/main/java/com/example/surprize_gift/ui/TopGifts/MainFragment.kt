package com.example.surprize_gift.ui.TopGifts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surprize_gift.data.api.GiftCardsNetworkService
import com.example.surprize_gift.data.api.IdeasNetworkService
import com.example.surprize_gift.data.repository.TopGiftsRepository
import com.example.surprize_gift.data.repository.TopIdeasRepository
import com.example.surprize_gift.databinding.FragmentMainBinding
import com.example.surprize_gift.ui.Ideas.IdeaAdapter
import com.example.surprize_gift.ui.Ideas.IdeaViewModel
import com.example.surprize_gift.ui.Ideas.IdeaViewModelFactory

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    lateinit var viewModel: GiftsViewModel


    private val retrofitService = GiftCardsNetworkService.getInstance()
    private val TAG = "GiftFrag"
    val adapter = GiftsAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this, GiftsViewModelFactory(TopGiftsRepository(retrofitService))).get(
                GiftsViewModel::class.java
            )

        val layoutManager = GridLayoutManager(view.context, 2)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position){
                    0 -> 2
                    else ->  1
                }
            }
        }

        binding.rvIdeas.layoutManager = layoutManager


        binding.rvIdeas.adapter = adapter
        viewModel.giftList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "ideaList: $it")
            adapter.setGiftList(it)
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getAllGifts()
    }
}