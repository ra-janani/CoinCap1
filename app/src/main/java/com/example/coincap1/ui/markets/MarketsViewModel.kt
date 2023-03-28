package com.example.coincap1.ui.markets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincap1.data.markets.MarketsModel
import com.example.coincap1.data.rates.RatesModel
import com.example.coincap1.remote.ApiDetails
import com.example.coincap1.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MarketsViewModel : ViewModel() {

    val markets = MutableLiveData<MarketsModel>()

    fun getMarkets() {
        val retrofitInstance = ApiDetails.getInstance().create(ApiRequest::class.java)

        GlobalScope.launch {
            val result = retrofitInstance.getMarkets()
            markets.postValue(result)
        }

    }
}