package com.example.coincap1.data.markets


import com.example.coincap1.data.markets.DataModel
import com.google.gson.annotations.SerializedName

data class MarketsModel(
    @SerializedName("data")
    val data: List<DataModel?>? = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)