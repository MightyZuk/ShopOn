package com.example.digitron.productFiles

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.NavUtils
import androidx.core.content.ContextCompat
import com.example.digitron.ProductsPage
import com.example.digitron.R
import com.example.digitron.databinding.ActivityCartBinding
import com.example.digitron.databinding.OrderDetailsLayoutBinding

class Cart : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
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

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}