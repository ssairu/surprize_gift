package com.example.surprize_gift.ui.Ideas

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surprize_gift.data.api.IdeasNetworkService
import com.example.surprize_gift.data.model.Idea
import com.example.surprize_gift.data.repository.TopIdeasRepository
import com.example.surprize_gift.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    lateinit var viewModel: IdeaViewModel

    private val retrofitService = IdeasNetworkService.getInstance()
    private val TAG = "IdeaFrag"
    val adapter = IdeaAdapter()


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
            ViewModelProvider(this, IdeaViewModelFactory(TopIdeasRepository(retrofitService))).get(
                IdeaViewModel::class.java
            )

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(view.context)
        binding.rvIdeas.layoutManager = layoutManager


        binding.rvIdeas.adapter = adapter
        viewModel.ideaList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "ideaList: $it")
            adapter.setIdeaList(it)
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getAllMovies()
    }
}