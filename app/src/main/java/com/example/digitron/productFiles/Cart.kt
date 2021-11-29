package com.example.digitron.productFiles

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitron.ProductsPage
import com.example.digitron.R
import com.example.digitron.database.ProductDetails
import com.example.digitron.database.ProductsViewModel
import com.example.digitron.databinding.ActivityCartBinding
import com.example.digitron.payments.Payments
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Cart : AppCompatActivity() {

    private lateinit var cartItemsList: ArrayList<ProductDetails>
    private lateinit var cartAdapter: CartRecyclerview

    @SuppressLint("RestrictedApi", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = "Shopping Cart"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
        window.statusBarColor = ContextCompat.getColor(this,R.color.red)
        setContentView(view)

        cartItemsList = ArrayList()
        cartAdapter = CartRecyclerview(this,cartItemsList)

        Firebase.firestore.collection("users").document(Firebase.auth.currentUser!!.displayName.toString())
            .collection("cartItems").get().addOnSuccessListener {
                if (it != null) {
                    for (doc in it) {
                        val key = doc.id
                        val value = doc.data.values
                        val valu = value.size
                        Log.d("title",valu.toString())

                        var n = 1

                        val product = ProductDetails(0, R.drawable.`as`, doc.id, null, "", "", n)
                        cartItemsList.add(product)

                    }
                    binding.cartItems.visibility = View.VISIBLE
                    binding.bottomNavigationView.visibility = View.VISIBLE
                    binding.emptyLayout.visibility = View.GONE
                } else {
                    binding.emptyLayout.visibility = View.VISIBLE
                    binding.cartItems.visibility = View.GONE
                    binding.bottomNavigationView.visibility = View.GONE
                }

            }


        binding.buyNow.setOnClickListener {
            Intent(this, ProductsPage::class.java).also { startActivity(it) }
        }

        binding.cartItems.layoutManager = LinearLayoutManager(this)
        binding.cartItems.adapter = cartAdapter
        binding.totalCost.text = "₹"+"12468"
        binding.proceedToCheckout.setOnClickListener{
            startActivity(Intent(this, Payments::class.java))
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}