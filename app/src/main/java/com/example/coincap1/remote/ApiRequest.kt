package com.example.coincap1.remote

import com.example.coincap1.data.assets.AssetsModel
import com.example.coincap1.data.exchanges.ExchangesModel
import com.example.coincap1.data.markets.MarketsModel
import com.example.coincap1.data.rates.RatesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {

    @GET(ApiDetails.END_PT1)
  suspend  fun getAssets():AssetsModel

    @GET(ApiDetails.END_PT2)
    suspend  fun getRates(): RatesModel

    @GET(ApiDetails.END_PT3)
    suspend  fun getExchanges(): ExchangesModel

    @GET(ApiDetails.END_PT4)
   suspend fun getMarkets() : MarketsModel


}