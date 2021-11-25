package com.example.digitron.productFiles

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitron.ProductsPage
import com.example.digitron.R
import com.example.digitron.databinding.ActivityCartBinding
import com.example.digitron.payments.Payments

class Cart : AppCompatActivity() {
    @SuppressLint("RestrictedApi", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = "Shopping bag"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
        window.statusBarColor = ContextCompat.getColor(this,R.color.red)
        setContentView(view)

        binding.buyNow.setOnClickListener {
            Intent(this, ProductsPage::class.java).also { startActivity(it) }
        }

        binding.cartItems.layoutManager = LinearLayoutManager(this)
        binding.cartItems.adapter = CartRecyclerview(this)
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