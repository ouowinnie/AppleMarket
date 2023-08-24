package com.example.applemarket

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemRecyclerviewBinding

class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }
        holder.listImage.setImageResource(mItems[position].listImage)
        holder.listTitle.text = mItems[position].listTitle
        holder.listAddress.text = mItems[position].listAddress
        holder.listPrice.text = mItems[position].listPrice
        holder.chatCount.text = mItems[position].chatCount.toString()
        holder.likeCount.text = mItems[position].likeCount.toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setItemClickListener(listener: ItemClick) {
        itemClick = listener
    }
    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val listImage = binding.listImage
        val listTitle = binding.listTitle
        val listAddress = binding.listAddress
        val listPrice = binding.listPrice
        val chatCount = binding.chatCount
        val likeCount = binding.likeCount
        init {
            listImage.clipToOutline = true

            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClick?.onClick(it, position)
                }
            }
        }
    }
}
