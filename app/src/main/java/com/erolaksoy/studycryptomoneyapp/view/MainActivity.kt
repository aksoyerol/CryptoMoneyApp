package com.erolaksoy.studycryptomoneyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erolaksoy.studycryptomoneyapp.R
import com.erolaksoy.studycryptomoneyapp.adapter.MySingleRowAdapter
import com.erolaksoy.studycryptomoneyapp.model.CryptoModel
import com.erolaksoy.studycryptomoneyapp.service.CryptoManager
import com.erolaksoy.studycryptomoneyapp.service.ICryptoApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://api.nomics.com/v1/"
    private var cryptoModels : ArrayList<CryptoModel>? = null
    private var recyclerViewAdapter : MySingleRowAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recycler view oluşturma, layout Manager ile recyler view kontrol edecğeiz
//        val linearLayout = LinearLayoutManager(this)
//        linearLayout.orientation = LinearLayoutManager.VERTICAL
//        var myRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        myRecyclerView.layoutManager = linearLayout
//
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = layoutManager
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

                            recyclerViewAdapter = MySingleRowAdapter(cryptoModels!!)
                            recyclerView.adapter = recyclerViewAdapter


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