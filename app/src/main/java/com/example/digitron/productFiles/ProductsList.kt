package com.example.digitron.productFiles

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.digitron.database.ProductDetails
import com.example.digitron.databinding.ProductsListBinding

class ProductsList(private val context: Context,
                   private val productDetails: MutableList<ProductDetails>): RecyclerView.Adapter<ProductsList.ItemViewHolder>() {

    private lateinit var binding : ProductsListBinding

    inner class ItemViewHolder(binding: ProductsListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ProductsListBinding.inflate(LayoutInflater.from(context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
        val current = productDetails[position]
        binding.productImage.setImageResource(current.image)
        binding.productTitle.text = current.title
        binding.category.text = current.category
        holder.itemView.setOnClickListener {
            Intent(context,ProductView::class.java).also {
                it.putExtra("image",current.image)
                it.putExtra("title",current.title)
                it.putExtra("price",current.price)
                context.startActivity(it) }
        }
    }

    override fun getItemCount(): Int {
        return productDetails.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}