package com.example.coincap.ui.rates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincap1.data.rates.RatesModel
import com.example.coincap1.data.repository.Repository
import com.example.coincap1.remote.ApiDetails
import com.example.coincap1.remote.ApiRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RatesViewModel @Inject constructor(
    val repository: Repository
):  ViewModel() {

    val rates = MutableLiveData<RatesModel>()

    fun getRates() {
       // val retrofitInstance = ApiDetails.getInstance().create(ApiRequest::class.java)

        viewModelScope.launch {
            val result = repository.getRates()
            rates.postValue(result)
        }

    }
}