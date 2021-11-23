package com.example.digitron.navigationComponent

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.digitron.R
import com.example.digitron.databinding.ActivityMyOrdersBinding

class MyOrders : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMyOrdersBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.red)
        supportActionBar?.title = "My Orders"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
        setContentView(binding.root)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}