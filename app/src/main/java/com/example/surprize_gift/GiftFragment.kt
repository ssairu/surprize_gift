package com.example.surprize_gift

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surprize_gift.databinding.FragmentMainBinding
import com.example.surprize_gift.databinding.SurpriseGiftFragmentBinding

class GiftFragment : Fragment() {
    companion object {
        fun newInstance() = GiftFragment()
    }

    private lateinit var binding: SurpriseGiftFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SurpriseGiftFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}