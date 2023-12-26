package com.example.surprize_gift

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surprize_gift.databinding.IdeaItemBinding


class IdeaAdapter(
    private val ideas: MutableList<Idea>,
) : RecyclerView.Adapter<IdeaAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: IdeaItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = IdeaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.headerIdea.text = ideas[position].title
            binding.bodyIdea.text = ideas[position].body
        }
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return ideas.size
    }
}