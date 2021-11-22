package com.example.digitron.navigationComponent

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.graphics.drawable.toIcon
import com.example.digitron.R
import com.example.digitron.databinding.ActivityAccountDetailsBinding
import com.example.digitron.databinding.NavHeaderLayoutBinding
import com.example.digitron.userDatabase.UserDao
import com.example.digitron.userentrance.ForgotPassword
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.FirebaseAuthKtxRegistrar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class AccountDetails : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAccountDetailsBinding.inflate(layoutInflater)
        val view= binding.root
        supportActionBar?.title= "Accounts"
        setContentView(view)

        binding.name.setText(FirebaseAuth.getInstance().currentUser?.displayName)
        binding.email.setText(FirebaseAuth.getInstance().currentUser?.email)
        binding.changePassword.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.changePassword -> {
                startActivity(Intent(this,ForgotPassword::class.java))
            }
        }
    }
}