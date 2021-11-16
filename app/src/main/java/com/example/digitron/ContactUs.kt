package com.example.digitron

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitron.databinding.ActivityContactUsBinding

class ContactUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContactUsBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = "Contact Us"
        setContentView(view)
    }

    fun takeMeToWhatsapp(view: android.view.View) {
        val whatsappUrl = Uri.parse("https://api.whatsapp.com/send/?phone=%2B917709266577&text&app_absent=0")
        startActivity(Intent(Intent.ACTION_VIEW,whatsappUrl))
    }
    fun takeMeToFacebook(view: android.view.View) {
        val facebookUrl = Uri.parse("https://www.facebook.com/DIGITRONLIFE")
        startActivity(Intent(Intent.ACTION_VIEW,facebookUrl))
    }

    fun takeMeToInstagram(view: android.view.View) {
        val instagramUrl = Uri.parse("https://www.instagram.com/digitronssoftwares1/")
        startActivity(Intent(Intent(Intent.ACTION_VIEW,instagramUrl)))
    }

    fun takeMeToLinkedin(view: android.view.View) {
        val linkedinUrl = Uri.parse("https://www.linkedin.com/company/digitron-softwares-and-technology/")
        startActivity(Intent(Intent(Intent.ACTION_VIEW,linkedinUrl)))
    }

    fun takeMeToYoutube(view: android.view.View) {
        val youtubeUrl = Uri.parse("https://www.youtube.com/channel/UCojsSw92BTSIwS_KEqMbusQ")
        startActivity(Intent(Intent.ACTION_VIEW,youtubeUrl))
    }

    fun takeMeToWebsite(view: android.view.View) {
        val websiteUrl = Uri.parse("http://digitronsoftwaresandtechnology.com/")
        startActivity(Intent(Intent.ACTION_VIEW,websiteUrl))
    }

    fun takeMeToSalesEmail(view: android.view.View) {}
    fun takeMeToMDEmail(view: android.view.View) {}
}