package com.example.digitron.userentrance

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.digitron.MainActivity
import com.example.digitron.R
import com.example.digitron.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = null
        setContentView(view)

        val user = "rahulcchauhan60@gmail.com"
        val pass = "RaChPro60@#"

        binding.sigInButton.setOnClickListener {
            if (binding.username.text.toString() == user && binding.password.text.toString() == pass){
                Intent(this,MainActivity::class.java).also { startActivity(it) }
            }else if (binding.username.text.toString() != user && binding.password.text.toString() == pass){
                Toast.makeText(this,"Please Enter correct username",Toast.LENGTH_SHORT).show()
            }else if (binding.username.text.toString() == user && binding.password.text.toString() != pass){
                Toast.makeText(this,"Please Enter correct password",Toast.LENGTH_SHORT).show()
            }else if(binding.username.text.isEmpty() && binding.password.text!!.isEmpty()){
                TODO()
            }else{
                Toast.makeText(this,"Please enter correct username and password",Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUpLittle.setOnClickListener {
            Intent(this,SignUp::class.java).also { startActivity(it) }
        }
    }
}