package com.erolaksoy.studycryptomoneyapp.service

import com.erolaksoy.studycryptomoneyapp.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface ICryptoApi {
    //GET,POST,UPDATE,DELETE
    @GET("prices?key=756ef08375803e486bee27af31183940")
    fun getData() : Call<List<CryptoModel>>
}