package com.example.surprize_gift.ui.topGifts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.surprize_gift.R
import com.example.surprize_gift.data.model.Gift
import com.example.surprize_gift.databinding.GiftCardBinding
import com.example.surprize_gift.databinding.MainHeadBinding
import com.example.surprize_gift.ui.home.MainActivity

class GiftsAdapter(

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var gifts = mutableListOf<Gift>()

    fun setGiftList(gifts: List<Gift>) {
        this.gifts = gifts.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val bindingHead = MainHeadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val bindingCards = GiftCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return when(viewType){
            0 -> HeadViewHolder(bindingHead)
            else -> CardsViewHolder(bindingCards)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            0 -> {
                val holder0 = holder as HeadViewHolder
                with(holder0) {
                    binding1.bigGift.setOnClickListener {
                        (binding1.root.context as MainActivity).toGift()
                    }
                }
            }
            1 -> {
                val holder1 = holder as CardsViewHolder
                with(holder1) {
                    binding.cardIdea.background = ResourcesCompat.getDrawable(binding.root.resources, R.drawable.radial_blue_1, null)
                    binding.headerIdea.text = gifts[position-1].title
                    binding.bodyIdea.text = gifts[position-1].description
                    binding.price.text = binding.root.context.getString(R.string.price, gifts[position - 1].price)
                }
            }
            2 -> {
                val holder1 = holder as CardsViewHolder
                with(holder1) {
                    binding.cardIdea.background = ResourcesCompat.getDrawable(binding.root.resources, R.drawable.radial_blue_2, null)
                    binding.headerIdea.text = gifts[position-1].title
                    binding.bodyIdea.text = gifts[position-1].description
                    binding.price.text = binding.root.context.getString(R.string.price, gifts[position - 1].price)
                }
            }
            3 -> {
                val holder1 = holder as CardsViewHolder
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
