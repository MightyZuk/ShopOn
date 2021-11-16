package com.example.digitron

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.digitron.databinding.ActivityMainBinding
import com.example.digitron.navigationComponent.AccountDetails
import com.example.digitron.userentrance.EnteranceScreen
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.smarteist.autoimageslider.SliderAnimations


class MainActivity : AppCompatActivity(),OnMapReadyCallback{

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_action_bar)
        setContentView(view)


        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.account -> startActivity(Intent(this,AccountDetails::class.java))
                R.id.logout -> startActivity(Intent(this,EnteranceScreen::class.java))
                R.id.share ->{
                    val sendIntent : Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT,"Check out this : ")
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent,"Share via")
                    startActivity(shareIntent)
                    }
                }
            true
        }

        val images = arrayOf(R.drawable.wd,R.drawable.dm,R.drawable.c_r_m)

        val sliderAdapter = ImageAdapter(this,images)
        binding.sliderView.setSliderAdapter(sliderAdapter)
        binding.sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        binding.sliderView.startAutoCycle()

        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.nav_open,R.string.nav_close)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }

    fun products(view: View) {
        Intent(this,ProductsPage::class.java).also { startActivity(it) }
    }

    fun aboutUs(view: View) {
        Intent(this,AboutUs::class.java).also { startActivity(it) }
    }

    fun contactUs(view: View) {
        Intent(this,ContactUs::class.java).also { startActivity(it) }
    }

    fun shopNow(view: View) {
        Intent(this,ProductsPage::class.java).also { startActivity(it) }
    }

    fun takeMeToWhatsapp(view: View) {
        val whatsappUrl = Uri.parse("https://api.whatsapp.com/send/?phone=%2B917709266577&text&app_absent=0")
        startActivity(Intent(Intent.ACTION_VIEW,whatsappUrl))
    }

    override fun onMapReady(map: GoogleMap) {
        map.addMarker(MarkerOptions().position(LatLng(21.126110238943085, 79.13540831252685))
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
            .title("Digitron Software & Technology"))
        Log.d("error","Error")
        map.moveCamera(CameraUpdateFactory
            .newLatLngZoom(LatLng(21.126110238943085, 79.13540831252685),14F))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return false
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}