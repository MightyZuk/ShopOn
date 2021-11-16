package com.example.digitron.userentrance

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitron.R
import com.example.digitron.databinding.ActivityEnteranceScreenBinding

class EnteranceScreen : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEnteranceScreenBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.hide()
        setContentView(view)

        binding.signIn.setOnClickListener {
            Intent(this,SignIn::class.java).also { startActivity(it) }
        }

        binding.signUp.setOnClickListener {
            Intent(this,SignUp::class.java).also { startActivity(it) }
        }
    }
}