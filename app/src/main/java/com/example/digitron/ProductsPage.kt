package com.example.digitron

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.util.LayoutDirection
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.digitron.database.ProductData
import com.example.digitron.database.ProductDetails
import com.example.digitron.database.ProductsViewModel
import com.example.digitron.databinding.ActivityProductsPageBinding
import com.example.digitron.databinding.BottomSheetBinding
import com.example.digitron.databinding.FilterBottomSheetBinding
import com.example.digitron.productFiles.Cart
import com.example.digitron.productFiles.ProductsList
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.properties.Delegates

class ProductsPage : AppCompatActivity() {

    private lateinit var viewModel: ProductsViewModel
    private lateinit var productsListAdapter: ProductsList
    private lateinit var list: ArrayList<ProductDetails>
    private lateinit var binding: ActivityProductsPageBinding

    private lateinit var tempList: ArrayList<ProductDetails>

    @SuppressLint("NotifyDataSetChanged", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsPageBinding.inflate(layoutInflater)
        val view = binding.root
        window.statusBarColor = ContextCompat.getColor(this,R.color.red)
        supportActionBar?.title = "Products"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
        setContentView(view)

        list = ArrayList()
        tempList = ArrayList()


        val pro = ProductData(this)

        viewModel = ViewModelProvider(this)[ProductsViewModel::class.java]
        for (i in pro.titles.indices){
            val product = ProductDetails(i,pro.images[i],pro.titles[i],pro.category[i],pro.description[i],pro.highlights[i],pro.price[i].toInt())
            list.add(product)
            viewModel.addProducts(product)
        }

        productsListAdapter = ProductsList(this,list)

        binding.listItem.layoutManager = GridLayoutManager(this,2)
        binding.listItem.adapter = productsListAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        val search = menu.findItem(R.id.search_bar)
        val searchView = search.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {
                productsListAdapter.filter.filter(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.shoppingBag -> {
                Intent(this,Cart::class.java).also { startActivity(it) }
                return false
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("CommitPrefEdits")
    fun filterBottomSheet(view: android.view.View) {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bind = FilterBottomSheetBinding.inflate(layoutInflater)
        bottomSheetDialog.setContentView(bind.root)
        bottomSheetDialog.show()

        val sharedPreferences = getSharedPreferences("id", MODE_PRIVATE)
        val radioButton1 = sharedPreferences.getInt("radioButton1",0)
        val editor1 = sharedPreferences.edit()


        when (radioButton1) {
            0 -> {
                bind.dataExtractor.isChecked = true
            }
            1 -> {
                bind.digitalMarketing.isChecked = true
            }
            2 -> {
                bind.mobile.isChecked = true
            }
            3 -> {
                bind.mobileApp.isChecked = true
            }
            4 -> {
                bind.mobileAppDevelopment.isChecked = true
            }
            5 -> {
                bind.software.isChecked = true
            }
            6 -> {
                bind.uncategorized.isChecked = true
            }
            7 -> {
                bind.webDevelopment.isChecked = true
            }
            8 -> {
                bind.website.isChecked = true
            }
            else -> {
                bind.websiteDesigning.isChecked = true
            }
        }

        bind.sortGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.dataExtractor ->{
                    editor1.putInt("radioButton1",0)
                    productsListAdapter.filter.filter("Data Extractor")
                }
                R.id.digitalMarketing ->{
                    editor1.putInt("radioButton1",1)
                    productsListAdapter.filter.filter("Digital Marketing")
                }
                R.id.mobile ->{
                    editor1.putInt("radioButton1",2)
                    productsListAdapter.filter.filter("Mobile")
                }
                R.id.mobileApp ->{
                    editor1.putInt("radioButton1",3)
                    productsListAdapter.filter.filter("Mobile App")

                }
                R.id.mobileAppDevelopment ->{
                    editor1.putInt("radioButton1",4)
                    productsListAdapter.filter.filter("Mobile App Development")
                }
                R.id.software ->{
                    editor1.putInt("radioButton1",5)
                    productsListAdapter.filter.filter("Software")

                }
                R.id.uncategorized ->{
                    editor1.putInt("radioButton1",6)
                    productsListAdapter.filter.filter("Uncategorized")
                }
                R.id.webDevelopment ->{
                    editor1.putInt("radioButton1",7)
                    productsListAdapter.filter.filter("Web Development")
                }
                R.id.website ->{
                    editor1.putInt("radioButton1",8)
                    productsListAdapter.filter.filter("Website")
                }
                R.id.websiteDesigning ->{
                    editor1.putInt("radioButton1",9)
                    productsListAdapter.filter.filter("Website Designing")
                }

            }
            editor1.apply()
            binding.listItem.adapter = productsListAdapter
            Handler(Looper.getMainLooper()).postDelayed({bottomSheetDialog.hide()},400)
        }
    }

    @SuppressLint("CommitPrefEdits")
    fun sortBottomSheet(view: android.view.View) {
        val bottom = BottomSheetDialog(this)
        val bind = BottomSheetBinding.inflate(layoutInflater)
        bottom.setContentView(bind.root)
        bottom.show()

        val sharedPreferences = getSharedPreferences("id", MODE_PRIVATE)
        val radioButton = sharedPreferences.getInt("radioButton",0)
        val editor = sharedPreferences.edit()

        when (radioButton) {
            0 -> {
                bind.popularity.isChecked = true
            }
            1 -> {
                bind.latest.isChecked = true
            }
            2 -> {
                bind.lowToHigh.isChecked = true
            }
            else -> {
                bind.highToLow.isChecked = true
            }
        }

        bind.sortGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.popularity ->{
                    editor.putInt("radioButton",0)
                    list.sortBy { it.title }
                }
                R.id.latest -> {
                    editor.putInt("radioButton",1)
                    list.sortByDescending { it.title }
                }
                R.id.lowToHigh -> {
                    editor.putInt("radioButton",2)
                    list.sortBy { it.price }
                }
                R.id.highToLow -> {
                    editor.putInt("radioButton",3)
                    list.sortByDescending { it.price }
                }
            }
            editor.apply()
            binding.listItem.adapter = productsListAdapter
            Handler(Looper.getMainLooper()).postDelayed({bottom.hide()},400)
        }
    }


}