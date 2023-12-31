package com.example.surprize_gift

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surprize_gift.databinding.IdeaItemBinding
import com.example.surprize_gift.databinding.MainHeadBinding


class IdeaAdapter(
    private val ideas: MutableList<Idea>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolder1(val binding1: MainHeadBinding) : RecyclerView.ViewHolder(binding1.root)
    inner class ViewHolder2(val binding: IdeaItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding1 = MainHeadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val binding2 = IdeaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        when(viewType){
            0 -> return ViewHolder1(binding1)
            1 -> return ViewHolder2(binding2)
        }
        return ViewHolder1(binding1)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            0 -> {
                val holder0 = holder as ViewHolder1
            }
            1 -> {
                val holder1 = holder as ViewHolder2
                with(holder1) {
                    binding.headerIdea.text = ideas[position-1].title
                    binding.bodyIdea.text = ideas[position-1].body
                }
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        if (position == 0){
            return 0
        }
        return 1
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return ideas.size+1
    }
}