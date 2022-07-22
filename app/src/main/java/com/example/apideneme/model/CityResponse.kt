package com.example.apideneme.model


import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("code")
    val code: String?,
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String?
)