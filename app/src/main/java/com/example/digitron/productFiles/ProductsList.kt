package com.example.digitron.productFiles

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filter.FilterResults
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.digitron.R
import com.example.digitron.database.ProductDetails
import com.example.digitron.databinding.ActivityProductsPageBinding
import com.example.digitron.databinding.ProductsListBinding
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class ProductsList(private val context: Context,
                   private val productDetails: ArrayList<ProductDetails>):
    RecyclerView.Adapter<ProductsList.ItemViewHolder>(),Filterable {

    var newList = productDetails

    private lateinit var binding : ProductsListBinding

    inner class ItemViewHolder(binding: ProductsListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ProductsListBinding.inflate(LayoutInflater.from(context),parent,false)
        return ItemViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
        val current = newList[position]
        current.image?.let { binding.productImage.setImageResource(it) }
        binding.productTitle.text = current.title
        binding.category.text = current.category
        binding.productPrice.text = "₹"+current.price.toString()
        holder.itemView.setOnClickListener {
            Intent(context,ProductView::class.java).also {
                it.putExtra("image",current.image)
                it.putExtra("title",current.title)
                it.putExtra("category",current.category)
                it.putExtra("highlights",current.highlights)
                it.putExtra("price",current.price)
                it.putExtra("description",current.description)
                context.startActivity(it) }
        }
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                newList = if (charSearch.isEmpty()) {
                    productDetails
                }else {
                    val resultList = ArrayList<ProductDetails>()
                    for (row in productDetails) {
                        if (row.title!!.lowercase(Locale.getDefault()).contains(charSearch.lowercase(Locale.getDefault()))
                            || row.category!!.lowercase(Locale.getDefault()).contains(charSearch.lowercase(Locale.getDefault()))){
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = newList
                return filterResults
            }

            @SuppressLint("NotifyDataSetChanged")
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                newList = results?.values as ArrayList<ProductDetails>
                notifyDataSetChanged()
            }
        }

    }

}