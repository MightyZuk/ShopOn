package com.example.digitron

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.digitron.databinding.ActivityAboutUsBinding

class AboutUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAboutUsBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = "About Us"
        window.statusBarColor = ContextCompat.getColor(this, R.color.red)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
        setContentView(view)

    }

    fun takeMeToWhatsapp(view: View) {
        val whatsappUrl = Uri.parse("https://api.whatsapp.com/send/?phone=%2B917709266577&text&app_absent=0")
        startActivity(Intent(Intent.ACTION_VIEW,whatsappUrl))
    }
}