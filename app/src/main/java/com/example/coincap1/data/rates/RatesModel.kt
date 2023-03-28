package com.example.coincap1.data.rates


import com.google.gson.annotations.SerializedName

data class RatesModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)