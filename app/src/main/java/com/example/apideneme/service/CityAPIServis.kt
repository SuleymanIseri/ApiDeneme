package com.example.apideneme.service

import com.example.apideneme.model.City
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CityAPIServis {

    //   https://mocki.io/v1/1432b876-72b0-4f5f-a66a-4184ddbf4d37
    //   Base_Url ->https://mocki.io/
    //   v1/1432b876-72b0-4f5f-a66a-4184ddbf4d37

    private val BASE_URL =  "https://mocki.io/v1/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CityAPI::class.java)


    fun getData() : Single<List<City>> {
        return api.getCity()

    }

}