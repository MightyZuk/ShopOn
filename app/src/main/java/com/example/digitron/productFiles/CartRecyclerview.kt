package com.example.digitron.productFiles

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.icu.number.NumberFormatter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.digitron.R
import com.example.digitron.database.ProductDetails
import com.example.digitron.databinding.ActivityCartBinding
import com.example.digitron.databinding.OrderDetailsLayoutBinding
import com.example.digitron.userDatabase.UserDao
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class CartRecyclerview(val context: Context,val list: ArrayList<ProductDetails>):
    RecyclerView.Adapter<CartRecyclerview.ItemViewHolder>(),AdapterView.OnItemSelectedListener{

    private lateinit var binding: OrderDetailsLayoutBinding

    inner class ItemViewHolder(binding: OrderDetailsLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = OrderDetailsLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ItemViewHolder(binding)
    }

    @DelicateCoroutinesApi
    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = list[position]
        val title = current.title
        val image = current.image
        val category = current.category
        val price = current.price
        val min = current.minQuantity
        val max = current.maxQuantity

        val array = arrayOf(1,2,3,4,5,6,7,8)

        val arrayAdapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,array)
        binding.quantityOfProduct.adapter = arrayAdapter
        binding.quantityOfProduct.onItemSelectedListener = this

//        binding.plus.setOnClickListener(this)
//        binding.minus.setOnClickListener(this)


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

        binding.imageOfProduct.setImageResource(image!!)
        binding.categoryOfProduct.text = category
        binding.titleOfProduct.text = title
        val formattedPrice = formatter.format(price)
        binding.priceOfProduct.text = formattedPrice

        val cart = ActivityCartBinding.inflate(LayoutInflater.from(context))

        Log.d("title: ", list.size.toString())

        binding.remove.setOnClickListener {
            if (title == list[position].title) {
                val dao = UserDao()
                dao.deleteCartItems(Firebase.auth.currentUser, title.toString())
                list.removeAt(position)
                notifyItemRemoved(position)
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    @DelicateCoroutinesApi
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


}