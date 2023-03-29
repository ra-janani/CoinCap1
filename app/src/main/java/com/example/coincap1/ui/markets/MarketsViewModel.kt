package com.example.coincap1.ui.markets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincap1.data.markets.MarketsModel
import com.example.coincap1.data.rates.RatesModel
import com.example.coincap1.data.repository.Repository
import com.example.coincap1.remote.ApiDetails
import com.example.coincap1.remote.ApiRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketsViewModel @Inject constructor(
    val repository: Repository
):  ViewModel() {

    val markets = MutableLiveData<MarketsModel>()

    fun getMarkets() {
        //val retrofitInstance = ApiDetails.getInstance().create(ApiRequest::class.java)

        viewModelScope.launch {
            val result = repository.getMarkets()
            markets.postValue(result)
        }

    }
}