package com.example.applemarket

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.applemarket.databinding.ActivityDetailBinding
import com.example.applemarket.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var likeIcon: ImageView
    private var isLiked = false
    private var likeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedItem = intent.getParcelableExtra<MyItem>("myItem")
        receivedItem?.let {
            binding.detailImage.setImageResource(it.listImage)
            binding.nickname.text = it.nickname
            binding.address.text = it.listAddress
            binding.detailTitle.text = it.listTitle
            binding.detailContent.text = it.detailContent
            binding.price.text = it.listPrice
        }

        // 좋아요와 뒤로가기 버튼
        likeIcon = binding.likeIcon
        likeIcon.setOnClickListener {
            isLiked = !isLiked
            if (isLiked) {
                likeIcon.setImageResource(R.drawable.love_filled)
            } else {
                likeIcon.setImageResource(R.drawable.love_empty)
            }
            val resultIntent = Intent()
            resultIntent.putExtra("isLiked", isLiked)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
        binding.backButton.setOnClickListener {
            finish()
        }
    }
}