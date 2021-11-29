package com.example.digitron.productFiles

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.digitron.R
import com.example.digitron.database.ProductDetails
import com.example.digitron.database.ProductsViewModel
import com.example.digitron.databinding.ActivityProductViewBinding
import com.example.digitron.userDatabase.UserDao
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductView : AppCompatActivity() {

    private lateinit var addToCartItems : HashMap<String,ProductDetails>
    private lateinit var viewModel: ProductsViewModel

    @DelicateCoroutinesApi
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

        viewModel = ViewModelProvider(this)[ProductsViewModel::class.java]

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
            GlobalScope.launch(Dispatchers.IO) {
                addToCart()
            }
            Toast.makeText(this,"Item added to cart",Toast.LENGTH_SHORT).show()
        }
    }

    @DelicateCoroutinesApi
    private fun addToCart() {
        addToCartItems = HashMap()
        val title = intent.getStringExtra("title")
        if (title != null) {
         val product = viewModel.getProductByTitle(title)
            addToCartItems[title] = product
            val dao = UserDao()
            dao.updateCartItems(addToCartItems,title)
        }
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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}