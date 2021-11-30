package com.example.digitron.navigationComponent

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.digitron.databinding.OrderItemsLayoutBinding

class MyOrdersAdapter(val context: Context):
    RecyclerView.Adapter<MyOrdersAdapter.OrderViewHolder>() {

    private lateinit var binding: OrderItemsLayoutBinding

    inner class OrderViewHolder(binding: OrderItemsLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        binding = OrderItemsLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val current = position
    }

    override fun getItemCount(): Int {
        return 5
    }
}