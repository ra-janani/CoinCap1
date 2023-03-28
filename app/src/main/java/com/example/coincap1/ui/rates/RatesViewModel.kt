package com.example.coincap.ui.rates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincap1.data.rates.RatesModel
import com.example.coincap1.remote.ApiDetails
import com.example.coincap1.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RatesViewModel : ViewModel() {

    val rates = MutableLiveData<RatesModel>()

    fun getRates() {
        val retrofitInstance = ApiDetails.getInstance().create(ApiRequest::class.java)

        GlobalScope.launch {
            val result = retrofitInstance.getRates()
            rates.postValue(result)
        }

    }
}