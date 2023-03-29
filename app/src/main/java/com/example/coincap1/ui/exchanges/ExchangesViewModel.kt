package com.example.coincap1.ui.exchanges

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincap1.data.exchanges.ExchangesModel
import com.example.coincap1.data.repository.Repository
import com.example.coincap1.remote.ApiDetails
import com.example.coincap1.remote.ApiRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangesViewModel @Inject constructor(
    val repository: Repository
) :  ViewModel() {

    val exchanges=MutableLiveData<ExchangesModel>()

    fun getExchanges() {
        //val retrofitInstance = ApiDetails.getInstance().create(ApiRequest::class.java)

        viewModelScope.launch {
            val result = repository.getExchanges()

            exchanges.postValue(result)
        }

    }
}