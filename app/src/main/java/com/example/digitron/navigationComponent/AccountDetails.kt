package com.example.digitron.navigationComponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitron.databinding.ActivityAccountDetailsBinding

class AccountDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAccountDetailsBinding.inflate(layoutInflater)
        val view= binding.root
        supportActionBar?.title= "Accounts"
        setContentView(view)
    }
}