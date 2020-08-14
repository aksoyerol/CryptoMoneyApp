package com.erolaksoy.studycryptomoneyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erolaksoy.studycryptomoneyapp.R
import com.erolaksoy.studycryptomoneyapp.model.CryptoModel
import com.erolaksoy.studycryptomoneyapp.service.CryptoManager
import com.erolaksoy.studycryptomoneyapp.service.ICryptoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://api.nomics.com/v1/"
    private var cryptoModels : List<CryptoModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val cryptoManager = CryptoManager()
//        val itemList = cryptoManager.getData()
//
//        if(itemList!=null){
//        for(item : CryptoModel in itemList!!){
//            println(item.price)
//            println(item.currency)
//        }
//        }
        loadData()
    }

    fun loadData(){
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(ICryptoApi::class.java)
        val call = service.getData()

        call.enqueue(object : Callback<List<CryptoModel>>{
            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        cryptoModels = ArrayList(it)

                        for (item : CryptoModel in cryptoModels!!) {
                        println(item.currency)
                            println(item.price)
                        }
                        }
                    }
                }


        })
    }
}