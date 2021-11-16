package com.example.digitron.userentrance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.digitron.MainActivity
import com.example.digitron.R
import com.example.digitron.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = null
        setContentView(view)

        binding.createAnAccountButton.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.signInLittle.setOnClickListener {
            Intent(this,SignIn::class.java).also {
                startActivity(it)
            }
        }
    }
}