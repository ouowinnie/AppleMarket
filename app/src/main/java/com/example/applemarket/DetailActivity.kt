package com.example.applemarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.applemarket.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var isLiked = false

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
            isLiked = it.isLiked == true
            binding.detailLikeIcon.setImageResource(if (isLiked) {R.drawable.love_filled} else {R.drawable.love_empty})
            binding.backButton.setOnClickListener {
                exit()
            }
            binding.detailLikeIcon.setOnClickListener {
                if(!isLiked){
                    binding.detailLikeIcon.setImageResource(R.drawable.love_filled)
                    Snackbar.make(binding.constLayout, "관심 목록에 추가되었습니다.", Snackbar.LENGTH_SHORT).show()
                    isLiked = true
                }else {
                    binding.detailLikeIcon.setImageResource(R.drawable.love_empty)
                    isLiked = false
                }
            }
        }
    }
    private fun exit() {
        val likePosition = intent.getIntExtra("likePosition", 0)
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("likePosition", likePosition)
            putExtra("isLiked", isLiked)
        }
        setResult(RESULT_OK, intent)
        if (!isFinishing) finish()
    }
    override fun onBackPressed() {
        exit()
    }
}