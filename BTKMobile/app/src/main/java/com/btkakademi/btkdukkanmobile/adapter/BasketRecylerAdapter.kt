package com.btkakademi.btkdukkanmobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.btkakademi.btkdukkanmobile.R
import com.btkakademi.btkdukkanmobile.model.Product
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.basket_recyler_row.view.*
import kotlinx.android.synthetic.main.recyler_row.view.*

class BasketRecylerAdapter (val basketList: List<Product>) : RecyclerView.Adapter<BasketRecylerAdapter.BasketViewHolder>() {
    class BasketViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.basket_recyler_row,parent,false)
        return BasketViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.itemView.basketProductNameText.text = basketList.get(position).name
        holder.itemView.basketProductPriceText.text = "Price : ${basketList.get(position).price}"
        holder.itemView.basketProductCountText.text = "Count : ${basketList.get(position).count}"
        Glide.with(holder.itemView.context).load(basketList.get(position).url).into(holder.itemView.basketImageView)

    }

    override fun getItemCount(): Int {
        return basketList.size
    }
}