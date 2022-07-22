package com.example.apideneme.service

import com.example.apideneme.model.CityResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CityAPI {

    //   https://mocki.io/v1/1432b876-72b0-4f5f-a66a-4184ddbf4d37
    //   Base_Url ->https://mocki.io/
    //   v1/1432b876-72b0-4f5f-a66a-4184ddbf4d37

    @GET("1432b876-72b0-4f5f-a66a-4184ddbf4d37")
    fun getCity() : Single<CityResponse>      //Call<List<City>>

}