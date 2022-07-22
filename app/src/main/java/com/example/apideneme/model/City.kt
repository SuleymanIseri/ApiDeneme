package com.example.apideneme.model


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("cityDesc")
    val cityDesc: String?,
    @SerializedName("cityName")
    val cityName: String?,
    @SerializedName("cityPopulation")
    val cityPopulation: Int?
)