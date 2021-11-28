package com.example.digitron.productFiles

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.digitron.database.ProductDetails
import com.example.digitron.databinding.OrderDetailsLayoutBinding

class CartRecyclerview(val context: Context,val list: ArrayList<ProductDetails>): RecyclerView.Adapter<CartRecyclerview.ItemViewHolder>() {

    private lateinit var binding: OrderDetailsLayoutBinding

    inner class ItemViewHolder(binding: OrderDetailsLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = OrderDetailsLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ItemViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = list[position]
        val title = current.title
        val image = current.image
        val category = current.category
        val price = current.price

        binding.imageOfProduct.setImageResource(image)
        binding.categoryOfProduct.text = category
        binding.titleOfProduct.text = title
        binding.priceOfProduct.text = "₹ $price"

        var n = 0
        binding.plus.setOnClickListener {
            n += 1
            if (n <= 10){
                binding.numberText.text = n.toString()
            }else{
                n = 10
            }
        }
        binding.minus.setOnClickListener{
            n -= 1
            if (n >= 0){
                binding.numberText.text = n.toString()
            }else{
                n = 0
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}