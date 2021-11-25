package com.example.digitron.productFiles

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.core.text.trimmedLength
import com.example.digitron.ProductsPage
import com.example.digitron.R
import com.example.digitron.database.ProductDetails
import com.example.digitron.databinding.ActivityProductViewBinding

class ProductView : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProductViewBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = null
        window.statusBarColor = ContextCompat.getColor(this, R.color.red)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
        setContentView(view)

        val image = intent.getIntExtra("image",0)
        val text = intent.getStringExtra("title")
        val price = intent.getIntExtra("price",0)

        binding.title.text = text.toString()

        binding.productImage.setImageResource(image)
        binding.price.text = "₹ $price"

        binding.details.text = "* The company Leads Extractor tool can smartly collect bulk customer data for digital marketing purposes.\n" +
                "* Extracts all email addresses and phone numbers from the source.\n" +
                "* This extractor is the FASTEST Software available on the internet.\n" +
                "* It is designed to extract email addresses and phone numbers with various criteria & various options to give the best results.\n" +
                "* The extracted email addresses and phone numbers can be saved such as.CSV or excel files.\n" +
                "* The extractor can UPDATE automatically, which helps you to get new features.\n" +
                "* It can extract 1000 emails & phone numbers from multiple files in a minute.\n" +
                "* Users can collect thousands of leads in one click.\n" +
                "* Targeted search for email addresses & contact numbers using keywords & input files.\n" +
                "* Unlimited data extraction no limitation at all.\n" +
                "* Multithreaded process for faster intelligent extraction.\n" +
                "* Automatic updates are with new features and settings instantly.\n" +
                "* The software has options to START – PAUSE – STOPin running mode.\n" +
                "* Users can export collected data into CSV or excel file format."

        binding.descript.text = "Ecommerce website design is the process of creating an online store for your business to sell digitally to target consumers. To design an e-commerce website, you need to plan, conceptualize, and arrange your content and products for effective display on the Internet."


        binding.card.setOnClickListener {
            if (binding.details.maxLines <= 8){
                binding.details.setLines(35)
                binding.details.setEms(0)
            }else{
                binding.details.setLines(8)
                binding.details.setEms(3)
            }
        }

        binding.buyNow.setOnClickListener {
            startActivity(Intent(this,Cart::class.java))
        }

        binding.addToCart.setOnClickListener{
            addToCart()
        }
    }

    private fun addToCart() {
        val current = intent.getStringExtra("current")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.product_view_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.shoppingBag -> {
                Intent(this,Cart::class.java).also { startActivity(it) }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}