package com.example.digitron

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.digitron.databinding.ActivityProductsPageBinding
import com.example.digitron.productFiles.Cart
import com.example.digitron.productFiles.ProductsList
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProductsPage : AppCompatActivity() {


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProductsPageBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = "Products"
        setContentView(view)

        val images = mutableListOf(R.drawable.billing_software,R.drawable.aap,R.drawable.`as`,R.drawable.cle,
        R.drawable.c_r_m,R.drawable.cs,R.drawable.cwd,R.drawable.dw,R.drawable.eapwe,R.drawable.dwd,R.drawable.ecommerce_website_promotion,
        R.drawable.elearning,R.drawable.elearning_portal_development,R.drawable.em,R.drawable.email_verifier,R.drawable.es,
        R.drawable.ess,R.drawable.ew,R.drawable.ewd,R.drawable.fad,R.drawable.fle,R.drawable.ga,R.drawable.google_maps_lead_extractor,
        R.drawable.had,R.drawable.hospital_management_software,R.drawable.iad,R.drawable.indiamart,R.drawable.imssoftware,
        R.drawable.iso,R.drawable.mam,R.drawable.mlm,R.drawable.mn,R.drawable.rnad,R.drawable.rspd,R.drawable.saps,
        R.drawable.seo,R.drawable.smapep,R.drawable.smm,R.drawable.smo,R.drawable.static_website,R.drawable.swd,R.drawable.wb,
        R.drawable.wdp)

        val productsListAdapter = ProductsList(this,images)
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