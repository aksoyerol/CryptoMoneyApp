package com.erolaksoy.studycryptomoneyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erolaksoy.studycryptomoneyapp.R
import com.erolaksoy.studycryptomoneyapp.model.CryptoModel

class MyViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context).inflate(R.layout.recyclerview_single_row,viewGroup,false)
) {

    val txtCurrency = viewGroup.findViewById<TextView>(R.id.txtViewCurrency)
    val txtPrice = viewGroup.findViewById<TextView>(R.id.txtViewPrice)

    fun bindData(model : CryptoModel){
       txtCurrency.text = model.currency
        txtPrice.text = model.price

    }

}