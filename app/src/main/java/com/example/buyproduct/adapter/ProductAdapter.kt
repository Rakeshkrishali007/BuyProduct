package com.example.buyproduct.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.buyproduct.MainActivity
import com.example.buyproduct.R
import com.example.buyproduct.model.Products

class ProductAdapter(private val productItem: ArrayList<Products>, private val context:Context): RecyclerView.Adapter<ProductVeiwHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVeiwHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent , false)
        return  ProductVeiwHolder(view)
    }

    override fun getItemCount(): Int {
        return  productItem.size
    }

    override fun onBindViewHolder(holder: ProductVeiwHolder, position: Int) {

        val currentData = productItem[position]
        holder.productTitle.text = currentData.title
        holder.productDescription.text = currentData.description
        Glide.with(context).load(currentData.image)
    }
}

class ProductVeiwHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val productTitle = itemView.findViewById<TextView>(R.id.tv_product_title)
    val productDescription = itemView.findViewById<TextView>(R.id.tv_product_description)
    val productImage = itemView.findViewById<ImageView>(R.id.img_product)
}