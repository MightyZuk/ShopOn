package com.example.digitron.productFiles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.NavUtils
import com.example.digitron.ProductsPage
import com.example.digitron.R
import com.example.digitron.databinding.ActivityCartBinding

class Cart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(view)

        binding.buyNow.setOnClickListener {
            Intent(this,ProductsPage::class.java).also { startActivity(it) }
        }
    }

}