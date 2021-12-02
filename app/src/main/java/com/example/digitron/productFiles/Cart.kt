package com.example.digitron.productFiles

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitron.ProductsPage
import com.example.digitron.R
import com.example.digitron.database.ProductData
import com.example.digitron.database.ProductDetails
import com.example.digitron.databinding.ActivityCartBinding
import com.example.digitron.databinding.OrderDetailsLayoutBinding
import com.example.digitron.payments.Payments
import com.example.digitron.userDatabase.UserDao
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class Cart : AppCompatActivity() {

    private lateinit var cartItemsList: ArrayList<ProductDetails>
    private lateinit var cartAdapter: CartRecyclerview
    private lateinit var dataList: ArrayList<ProductDetails>
    private lateinit var dialog: Dialog
    private var formattedPrice by Delegates.notNull<String>()
    private lateinit var binding: ActivityCartBinding

    @SuppressLint("RestrictedApi", "SetTextI18n", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = "Shopping Cart"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
        window.statusBarColor = ContextCompat.getColor(this,R.color.red)
        setContentView(view)

        cartItemsList = ArrayList()
        dataList = ArrayList()
        cartAdapter = CartRecyclerview(this,cartItemsList)

        loadingDialog()
        loadData()

        val pro = ProductData(this)
        for (i in pro.titles.indices){
            val product = ProductDetails(
                i,pro.images[i],pro.titles[i],pro.category[i],
                pro.description[i],pro.highlights[i],pro.price[i].toInt(),1,10)
            dataList.add(product)
        }

        binding.buyNow.setOnClickListener {
            Intent(this, ProductsPage::class.java).also { startActivity(it) }
        }

        binding.cartItems.layoutManager = LinearLayoutManager(this)
        binding.cartItems.adapter = cartAdapter

        binding.proceedToCheckout.setOnClickListener{
            Intent(this,Payments::class.java).also {
                it.putExtra("totalPrice",formattedPrice)
                startActivity(it)
            }
        }

    }

    private fun loadData(){
        Firebase.firestore.collection("users").document(Firebase.auth.currentUser!!.displayName.toString())
            .collection("cartItems").get().addOnSuccessListener {
                if (it != null) {
                    var total = 0
                    for (id in it) {
                        val docId = id.id
                        for (i in dataList) {
                            if (i.title!!.contains(docId)) {
                                val title = i.title.toString()
                                val category = i.category.toString()
                                val image = i.image
                                val price = i.price!!
                                val description = i.description
                                val highlights = i.highlights
                                val product = ProductDetails(
                                    i.id, image, title, category, description, highlights,
                                    price, 1, 10)
                                cartItemsList.add(product)
                                total += price
                            }
                        }
                    }
                    var totalPrice = total
                    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
                    formattedPrice = formatter.format(totalPrice)
                    binding.totalCost.text = formattedPrice
                    dialog.dismiss()
                    if (cartItemsList.isEmpty()){
                        binding.cartItems.visibility = View.GONE
                        binding.emptyLayout.visibility = View.VISIBLE
                        binding.bottomNavigationView.visibility = View.GONE
                    }else{
                        binding.cartItems.visibility = View.VISIBLE
                        binding.bottomNavigationView.visibility = View.VISIBLE
                        binding.emptyLayout.visibility = View.GONE
                    }
                }

            }
    }

    private fun loadingDialog() {
        dialog = Dialog(this)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.loading_dialog)
        dialog.create()
        dialog.show()
    }

    override fun onBackPressed() {
        NavUtils.navigateUpFromSameTask(this)
        super.onBackPressed()
    }
}