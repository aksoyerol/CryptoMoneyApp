package com.erolaksoy.studycryptomoneyapp.service

import com.erolaksoy.studycryptomoneyapp.model.CryptoModel
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class CryptoManager {
    private val BASE_URL = "https://api.nomics.com/v1/"
    private var cryptoModels : List<CryptoModel>? = null


     fun getData(): List<CryptoModel>? {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(ICryptoApi::class.java)
        val call = service.getData()

        call.enqueue(object  : Callback<List<CryptoModel>>{
            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
              t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
                if(response.isSuccessful) {
                    response.body()?.let {
                         cryptoModels = ArrayList(it)

                    }

                }
            }

        })

       return cryptoModels

        }
}