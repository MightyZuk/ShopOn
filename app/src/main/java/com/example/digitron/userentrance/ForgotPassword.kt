package com.example.digitron.userentrance

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.digitron.R
import com.example.digitron.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPassword : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.red)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
        setContentView(binding.root)

        auth = Firebase.auth

        binding.resetPassword.setOnClickListener{
            val email = binding.forgotEmail.text.toString().trim()
            if (email.isEmpty()){
                binding.forgotEmail.error = "Required"
                binding.forgotEmail.requestFocus()
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.forgotEmail.error = "Please provide a valid email"
                binding.forgotEmail.requestFocus()
            }
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(this,"Check your email",Toast.LENGTH_SHORT)
                    }else{
                        Toast.makeText(this,"Try again after some time",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}