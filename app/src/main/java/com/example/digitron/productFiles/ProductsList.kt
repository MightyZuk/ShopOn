package com.example.digitron.productFiles

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.digitron.databinding.ProductsListBinding

class ProductsList(private val context: Context): RecyclerView.Adapter<ProductsList.ItemViewHolder>() {

    private lateinit var binding : ProductsListBinding

    inner class ItemViewHolder(binding: ProductsListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ProductsListBinding.inflate(LayoutInflater.from(context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
        holder.itemView.setOnClickListener {
            Intent(context,ProductView::class.java).also { context.startActivity(it) }
        }
    }

    override fun getItemCount(): Int {
        return 10
    }


}