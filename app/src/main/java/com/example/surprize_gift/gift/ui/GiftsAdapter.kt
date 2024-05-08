package com.example.surprize_gift.gift.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.surprize_gift.R
import com.example.surprize_gift.gift.data.Gift
import com.example.surprize_gift.databinding.GiftCardBinding
import com.example.surprize_gift.databinding.MainHeadBinding
import com.example.surprize_gift.ui.base.MainActivity

class GiftsAdapter(

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var gifts = mutableListOf<Gift>()

    fun setGiftList(gifts: List<Gift>) {
        this.gifts = gifts.toMutableList()
        notifyDataSetChanged()
    }
    inner class ViewHolder1(val binding1: MainHeadBinding) : RecyclerView.ViewHolder(binding1.root)
    inner class ViewHolder2(val binding: GiftCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding1 = MainHeadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val binding2 = GiftCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return when(viewType){
            0 -> ViewHolder1(binding1)
            else -> ViewHolder2(binding2)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            0 -> {
                val holder0 = holder as ViewHolder1
                with(holder0) {
                    binding1.bigGift.setOnClickListener {
                        (binding1.root.context as MainActivity).toGift()
                    }
                }
            }
            1 -> {
                val holder1 = holder as ViewHolder2
                with(holder1) {
                    binding.cardIdea.background = ResourcesCompat.getDrawable(binding.root.resources, R.drawable.radial_blue_1, null)
                    binding.headerIdea.text = gifts[position-1].title
                    binding.bodyIdea.text = gifts[position-1].description
                    binding.price.text = binding.root.context.getString(R.string.price, gifts[position - 1].price)
                }
            }
            2 -> {
                val holder1 = holder as ViewHolder2
                with(holder1) {
                    binding.cardIdea.background = ResourcesCompat.getDrawable(binding.root.resources, R.drawable.radial_blue_2, null)
                    binding.headerIdea.text = gifts[position-1].title
                    binding.bodyIdea.text = gifts[position-1].description
                    binding.price.text = binding.root.context.getString(R.string.price, gifts[position - 1].price)
                }
            }
            3 -> {
                val holder1 = holder as ViewHolder2
                with(holder1) {
                    binding.cardIdea.background = ResourcesCompat.getDrawable(binding.root.resources, R.drawable.radial_blue_3, null)
                    binding.headerIdea.text = gifts[position-1].title
                    binding.bodyIdea.text = gifts[position-1].description
                    binding.price.text = binding.root.context.getString(R.string.price, gifts[position - 1].price)
                }
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        if (position == 0){
            return 0
        }
        when ((position - 1) % 3) {
            0 -> return 1
            1 -> return 2
            2 -> return 3
        }
        return 1
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return gifts.size+1
    }
}
