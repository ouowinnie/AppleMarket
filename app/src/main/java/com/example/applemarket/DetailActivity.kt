package com.example.applemarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.applemarket.databinding.ActivityDetailBinding
import com.example.applemarket.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

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
        // 상세페이지 뒤로가기
        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}