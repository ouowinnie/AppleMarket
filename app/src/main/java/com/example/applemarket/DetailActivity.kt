package com.example.applemarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }
}