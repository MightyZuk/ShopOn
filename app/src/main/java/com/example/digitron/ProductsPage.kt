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
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
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

class ProductsPage : AppCompatActivity() {

    private lateinit var images: Array<Int>
    private lateinit var titles: Array<String>
    private lateinit var category: Array<String>
    private lateinit var viewModel: ProductsViewModel
    private lateinit var productsListAdapter: ProductsList
    private lateinit var list: MutableList<ProductDetails>
    private lateinit var binding: ActivityProductsPageBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsPageBinding.inflate(layoutInflater)
        val view = binding.root
        window.statusBarColor = ContextCompat.getColor(this,R.color.red)
        supportActionBar?.title = "Products"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
        setContentView(view)

        images  = arrayOf(R.drawable.`as`,R.drawable.aap,R.drawable.billing_software,R.drawable.email_verifier,
            R.drawable.wb,R.drawable.cle,R.drawable.c_r_m,R.drawable.cs,R.drawable.cwd,R.drawable.dbc,R.drawable.dwd,R.drawable.dw,
            R.drawable.ewd,R.drawable.ew,R.drawable.elearning,R.drawable.elearning_portal_development,R.drawable.ecommerce_website_promotion,
            R.drawable.es,R.drawable.eapwe,R.drawable.em,R.drawable.ess,R.drawable.fle,R.drawable.fad,R.drawable.ga,R.drawable.google_maps_lead_extractor,
            R.drawable.hospital_management_software,R.drawable.had,R.drawable.indiamart,R.drawable.iad,R.drawable.iso,
            R.drawable.mlm,R.drawable.mam,R.drawable.mn,R.drawable.rnad,R.drawable.rspd,R.drawable.saps,
            R.drawable.seo,R.drawable.smapep,R.drawable.smm,R.drawable.smo,R.drawable.static_website,R.drawable.swd,R.drawable.wb,
            R.drawable.wdp)

        titles = arrayOf("Accommodation Software","Android App Development","Billing Software","Bulk Email Verifier","Bulk Messenger","Company Lead Extractor",
        "CRM","Custom Software","Custom Web Designing","Digital Business Card","Dynamic Web Designing","Dynamic Website","E-commerce Web Designing","E-commerce Website",
        "E-learning app","E-learning Portal Development","Ecommerce Website Promotion","Educational Software","Email & Phone Web Extractor","Email Marketing",
        "Enterprise Software Solution","Facebook Lead Extractor","Flutter App Development","Google Adwords","Googlemap Lead Extractor","Hospital Management Software",
        "Hybrid App Development","Indiamart Extractor","Iconic App Development","Ios App Development","Just Dial Data Extractor","Linkedin Extractor","LMS Software",
        "MLM Software","Mobile App Maintenance","Mobile Number Lookup","React Native App Development","Real Estate Portal Development","Sales & Purchase Software",
        "SEO Marketing","Social Email Phone Extractor Pro","Social Media Marketing","Static Web Designing","Static Website","TradeIndia Lead Extractor","Transportation Software",
        "Web Portal Development")

        category = arrayOf("Mobile","Software","Web","Mobile","Software","Web","Mobile","Software","Web",
            "Mobile","Software","Web","Mobile","Software","Web","Mobile","Software","Web","Mobile","Software","Web",
            "Mobile","Software","Web","Mobile","Software","Web","Mobile","Software","Web","Mobile","Software","Web",
            "Mobile","Software","Web","Mobile","Software","Web","Mobile","Software","Web","Mobile","Software","Web",
            "Mobile","Software","Web","Mobile","Software","Web","Mobile","Software","Web","Mobile","Software","Web")

        list = ArrayList()
        images.sortedArray()
        titles.sortedArray()

        viewModel = ViewModelProvider(this)[ProductsViewModel::class.java]
        var price = 0

        for ((id, i) in (images.indices).withIndex()){
            val product = ProductDetails(id,images[i],titles[i],category[i],"description","Highlights",price++)
            list.add(product)
            viewModel.addProducts(product)
        }


        productsListAdapter = ProductsList(this,list)

        binding.listItem.layoutManager = GridLayoutManager(this,2)
        binding.listItem.adapter = productsListAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
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
        val radioButton = sharedPreferences.getInt("radioButton",0)
        val editor = sharedPreferences.edit()


        when (radioButton) {
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
                    editor.putInt("radioButton",0)
                    list.sortBy { it.category.contains("Data Extractor") }
                }
                R.id.digitalMarketing ->{
                    editor.putInt("radioButton",1)
                    list.sortBy { it.category.contains("Digital Marketing") }
                }
                R.id.mobile ->{
                    editor.putInt("radioButton",2)
                    list.sortBy { it.category.contains("Mobile") }
                }
                R.id.mobileApp ->{
                    editor.putInt("radioButton",3)
                    list.sortBy { it.category.contains("Mobile App")}
                }
                R.id.mobileAppDevelopment ->{
                    editor.putInt("radioButton",4)
                    list.sortBy { it.category.contains("Mobile App Development") }
                }
                R.id.software ->{
                    editor.putInt("radioButton",5)
                    list.sortBy { it.category.contains("Software") }
                }
                R.id.uncategorized ->{
                    editor.putInt("radioButton",6)
                    list.sortBy { it.category.contains("Uncategorized")}
                }
                R.id.webDevelopment ->{
                    editor.putInt("radioButton",7)
                    list.sortBy { it.category.contains("Web Development") }
                }
                R.id.website ->{
                    editor.putInt("radioButton",8)
                    list.sortBy { it.category.contains("Website") }
                }
                R.id.websiteDesigning ->{
                    editor.putInt("radioButton",9)
                    list.sortBy { it.category.contains("Website Designing") }
                }

            }
            editor.apply()
            binding.listItem.adapter = productsListAdapter
            Handler(Looper.getMainLooper()).postDelayed({bottomSheetDialog.hide()},400)
        }
    }

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