package com.example.coincap1.data.assets


import com.google.gson.annotations.SerializedName

data class AssetsModel(
    @SerializedName("data")
    val data: List<DataModel?>? = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)