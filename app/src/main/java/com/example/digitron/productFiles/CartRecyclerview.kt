package com.example.digitron.productFiles

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.icu.number.NumberFormatter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.digitron.R
import com.example.digitron.database.ProductDetails
import com.example.digitron.databinding.OrderDetailsLayoutBinding
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class CartRecyclerview(val context: Context,val list: ArrayList<ProductDetails>):
    RecyclerView.Adapter<CartRecyclerview.ItemViewHolder>(),
    View.OnClickListener {

    private lateinit var binding: OrderDetailsLayoutBinding
    private var number by Delegates.notNull<Int>()

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
        var min = current.minQuantity
        var max = current.maxQuantity

        number = min!!

        binding.plus.setOnClickListener(this)
        binding.minus.setOnClickListener(this)


        holder.itemView.setOnClickListener{
            val intent = Intent(context,ProductView::class.java)
            intent.putExtra("title",title)
            intent.putExtra("image",image)
            intent.putExtra("category",category)
            intent.putExtra("description",current.description)
            intent.putExtra("highlights",current.highlights)
            intent.putExtra("price",price)
            it.context.startActivity(intent)
        }

        val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
        val formattedPrice = formatter.format(price)

        binding.imageOfProduct.setImageResource(image!!)
        binding.categoryOfProduct.text = category
        binding.titleOfProduct.text = title
        binding.priceOfProduct.text = formattedPrice
        binding.numberText.text = number.toString()

//        var n = min
//        binding.plus.setOnClickListener {
//            n = n?.plus(1)
//            if (n!! <= 10){
//                binding.numberText.text = n.toString()
//            }else{
//                n = max
//            }
//        }
//        binding.minus.setOnClickListener{
//            n = min?.let { it1 -> n?.minus(it1) }
//            if (n!! >= 0){
//                binding.numberText.text = n.toString()
//            }else{
//                n = 0
//            }
//        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onClick(v: View?) {
        var n = number
        when(v?.id){
            R.id.plus -> {
                n += 1
                number = n
            }
            R.id.minus -> {
                n -= 1
                number = n
            }
        }
    }

}