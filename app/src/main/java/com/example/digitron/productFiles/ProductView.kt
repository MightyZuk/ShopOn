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

    private lateinit var addToCartItems : MutableList<ProductDetails>

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
        val category = intent.getStringExtra("category")
        val description = intent.getStringExtra("description")
        val highlights = intent.getStringExtra("highlights")

        binding.title.text = text.toString()

        binding.productImage.setImageResource(image)
        binding.category.text = "Category : $category"
        binding.price.text = "₹ $price"

        binding.details.text = highlights

        binding.descript.text = description

//        binding.card.setOnClickListener {
//            if (binding.details.maxLines <= 8){
//                binding.details.setLines(highlights!!.length)
//                binding.details.setEms(0)
//            }else{
//                binding.details.setLines(8)
//                binding.details.setEms(3)
//            }
//        }

        binding.buyNow.setOnClickListener {
            startActivity(Intent(this,Cart::class.java))
        }

        binding.addToCart.setOnClickListener{
            addToCart()
        }
    }

    private fun addToCart() {
        

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