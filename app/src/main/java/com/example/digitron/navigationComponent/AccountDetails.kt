package com.example.digitron.navigationComponent

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toIcon
import com.example.digitron.R
import com.example.digitron.databinding.ActivityAccountDetailsBinding
import com.example.digitron.databinding.NavHeaderLayoutBinding
import com.example.digitron.userDatabase.UserDao
import com.example.digitron.userentrance.ForgotPassword
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.FirebaseAuthKtxRegistrar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AccountDetails : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAccountDetailsBinding

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountDetailsBinding.inflate(layoutInflater)
        val view= binding.root
        supportActionBar?.title= "Accounts"
        window.statusBarColor = ContextCompat.getColor(this, R.color.red)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
        setContentView(view)


            Firebase.firestore.collection("users").document(Firebase.auth.uid.toString())
                .get().addOnSuccessListener {
                    if (it != null) {
                        binding.name.setText(it.getString("name"))
                        binding.email.setText(it.getString("email"))
                        binding.userImage.text = it.getString("name")?.get(0)?.toUpperCase().toString()
                    } else {
                        Toast.makeText(this@AccountDetails, "Can't fetch data", Toast.LENGTH_SHORT)
                            .show()
                    }
                }


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