package com.erolaksoy.studycryptomoneyapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erolaksoy.studycryptomoneyapp.model.CryptoModel

class MySingleRowAdapter(val cryptoListModel : List<CryptoModel>) : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return cryptoListModel.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(cryptoListModel[position])
    }

}