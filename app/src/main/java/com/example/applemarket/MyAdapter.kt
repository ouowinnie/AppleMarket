package com.example.applemarket

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemRecyclerviewBinding

class MyAdapter(private val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }
    interface LongItemClick {
        fun onLongClick(view : View, position : Int)
    }
    var itemClick : ItemClick? = null
    var longItemClick : LongItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.listImage.setImageResource(mItems[position].listImage)
        holder.listTitle.text = mItems[position].listTitle
        holder.listAddress.text = mItems[position].listAddress
        holder.listPrice.text = mItems[position].listPrice
        holder.chatCount.text = mItems[position].chatCount.toString()
        holder.likeCount.text = mItems[position].likeCount.toString()
        if(mItems[position].isLiked)
            holder.likeIcon.setImageResource(R.drawable.love_filled)
        else
            holder.likeIcon.setImageResource(R.drawable.love_empty)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(private val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val listImage = binding.listImage
        val listTitle = binding.listTitle
        val listAddress = binding.listAddress
        val listPrice = binding.listPrice
        val chatCount = binding.chatCount
        val likeCount = binding.likeCount
        val likeIcon = binding.likeIcon
        init {
            listImage.clipToOutline = true

            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClick?.onClick(it, position)
                }
            }
            binding.root.setOnLongClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    longItemClick?.onLongClick(it, position)
                    true
                } else {
                    false
                }
            }
        }
    }
}

class AddressAdapterDecoration : RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val paint = Paint()
        paint.color = Color.GRAY

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val layoutParams = child.layoutParams as RecyclerView.LayoutParams
            val top = (child.bottom + layoutParams.bottomMargin + 10).toFloat()
            val bottom = top + 1f

            val left = parent.paddingStart.toFloat()
            val right = (parent.width - parent.paddingEnd).toFloat()

            c.drawRect(left, top, right, bottom, paint)
        }
    }
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val offset = 10
        outRect.top = offset
        outRect.bottom = offset
    }
}