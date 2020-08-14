package com.erolaksoy.studycryptomoneyapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erolaksoy.studycryptomoneyapp.R
import com.erolaksoy.studycryptomoneyapp.model.CryptoModel
import kotlinx.android.synthetic.main.recyclerview_single_row.view.*
import java.text.FieldPosition

class MyViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context).inflate(R.layout.recyclerview_single_row,viewGroup,false)
) {

    val txtCurrency = viewGroup.findViewById<TextView>(R.id.txtViewCurrency)
    val txtPrice = viewGroup.findViewById<TextView>(R.id.txtViewPrice)

    fun bindData(model : CryptoModel, colors : Array<String>, position: Int){
        itemView.setBackgroundColor(Color.parseColor(colors[position%colors.size]))
        itemView.txtViewCurrency.text = model.currency
itemView.txtViewPrice.text = model.price
    }

}