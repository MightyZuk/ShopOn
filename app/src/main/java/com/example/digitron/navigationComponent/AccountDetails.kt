package com.example.digitron.navigationComponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.graphics.drawable.toIcon
import com.example.digitron.databinding.ActivityAccountDetailsBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccountDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAccountDetailsBinding.inflate(layoutInflater)
        val view= binding.root
        supportActionBar?.title= "Accounts"
        setContentView(view)

        val auth = Firebase.auth.currentUser!!

        val image = auth.photoUrl
        val user = auth.displayName
        val email = auth.email

        binding.userImage.setImageURI(image)
        binding.name.setText(user)
        binding.email.setText(email)
    }
}