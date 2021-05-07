package com.btkakademi.btkdukkanmobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.btkakademi.btkdukkanmobile.R
import com.btkakademi.btkdukkanmobile.model.Product
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyler_row.view.*

class ProductRecyclerAdapter(val productList: List<Product>,private val listener: ProductListener) : RecyclerView.Adapter<ProductRecyclerAdapter.ProductHolder>() {

    class ProductHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyler_row,parent,false)
        return  ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.itemView.productName.text = productList.get(position).name
        holder.itemView.productPrice.text = productList.get(position).price
        Glide.with(holder.itemView.context).load(productList.get(position).url).into(holder.itemView.productImage)
        holder.itemView.addBasketButton.setOnClickListener {
            Toast.makeText(it.context," ${productList.get(position).name} Added to Basket ",Toast.LENGTH_SHORT).show()
            listener.onItemClick(productList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return  productList.size
    }

    interface ProductListener{
        fun onItemClick(product: Product)
    }
}