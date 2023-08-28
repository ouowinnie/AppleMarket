package com.example.applemarket


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyItem(
    val listImage: Int,
    val listTitle: String,
    val listAddress: String,
    val listPrice: String,
    val chatCount: Int,
    var likeCount: Int,
    val nickname: String,
    val detailContent: String
) : Parcelable