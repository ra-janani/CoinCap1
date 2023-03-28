package com.example.coincap1.ui.exchanges

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincap1.data.exchanges.ExchangesModel
import com.example.coincap1.remote.ApiDetails
import com.example.coincap1.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExchangesViewModel : ViewModel() {

    val exchanges=MutableLiveData<ExchangesModel>()

    fun getExchanges() {
        val retrofitInstance = ApiDetails.getInstance().create(ApiRequest::class.java)

        GlobalScope.launch {
            val result = retrofitInstance.getExchanges()

            exchanges.postValue(result)
        }

    }
}