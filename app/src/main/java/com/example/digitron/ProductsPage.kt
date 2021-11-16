package com.example.digitron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitron.databinding.ActivityProductsPageBinding
import com.example.digitron.productFiles.Cart
import com.example.digitron.productFiles.ProductsList
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProductsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProductsPageBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = "Products"
        setContentView(view)
        
        val productsListAdapter = ProductsList(this)
        binding.listItem.layoutManager = GridLayoutManager(this,2)
        binding.listItem.adapter = productsListAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
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

    fun filterBottomSheet(view: android.view.View) {
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.filter_bottom_sheet)
        bottomSheetDialog.show()
    }

    fun sortBottomSheet(view: android.view.View) {
        val bottom = BottomSheetDialog(this)
        bottom.setContentView(R.layout.bottom_sheet)
        bottom.show()
    }

}