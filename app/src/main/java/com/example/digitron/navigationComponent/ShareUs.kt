package com.example.digitron.navigationComponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitron.databinding.ActivityShareUsBinding

class ShareUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityShareUsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}