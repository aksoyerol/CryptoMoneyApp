package com.erolaksoy.studycryptomoneyapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erolaksoy.studycryptomoneyapp.model.CryptoModel

class MySingleRowAdapter(private val cryptoListModel : ArrayList<CryptoModel>) : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(parent)
    }
    //////////////////////

    override fun getItemCount(): Int {
        return cryptoListModel.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val colors :Array<String> = arrayOf("#FFA07A","#1874CD","#efefef","#3B5323","#8A3324")
        holder.bindData(cryptoListModel[position],colors,position)
    }

}