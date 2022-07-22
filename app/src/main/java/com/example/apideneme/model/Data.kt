package com.example.apideneme.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("cities")
    val cities: List<City>?
)