package com.example.coincap1.remote

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiDetails {
    const val BASE_URL1 = "https://api.coincap.io"
    const val END_PT1 = "/v2/assets"
    const val END_PT2 = "/v2/rates"
    const val END_PT3="/v2/exchanges"
    const val END_PT4 = "/v2/markets"

    fun getInstance(): Retrofit =
        Retrofit.Builder()//its pattern that helps build an object with different properties
            .baseUrl(BASE_URL1) // setting the common BASE url for all
            .addConverterFactory(GsonConverterFactory.create(Gson())) //Convert your JSON data to Data class

            .build() // finalize the object/builder
}