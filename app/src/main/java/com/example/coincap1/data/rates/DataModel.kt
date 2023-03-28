package com.example.coincap1.data.rates


import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("currencySymbol")
    val currencySymbol: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("rateUsd")
    val rateUsd: String? = "",
    @SerializedName("symbol")
    val symbol: String? = "",
    @SerializedName("type")
    val type: String? = ""
):java.io.Serializable