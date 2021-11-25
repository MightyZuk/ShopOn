package com.example.digitron

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.digitron.databinding.ActivityMainBinding
import com.example.digitron.navigationComponent.AccountDetails
import com.example.digitron.navigationComponent.MyOrders
import com.example.digitron.productFiles.Cart
import com.example.digitron.userentrance.SignIn
import com.google.android.gms.auth.GoogleAuthUtil
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.coroutines.DelicateCoroutinesApi
import org.w3c.dom.Text


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_action_bar)
        setContentView(view)


        Firebase.firestore.collection("users").document(Firebase.auth.uid.toString())
            .get().addOnSuccessListener {
                if (it != null){
                    val b = binding.navigationView.getHeaderView(0)
                    b.findViewById<TextView>(R.id.userTop).text = it.getString("name")
                    b.findViewById<TextView>(R.id.image).text = it.getString("name")?.get(0)?.toUpperCase().toString()
                }else{
                    Toast.makeText(this,"Can't fetch data",Toast.LENGTH_SHORT).show()
                }
            }

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.account -> startActivity(Intent(this,AccountDetails::class.java))
                R.id.logout -> {
                    signOut()
                }
                R.id.bag -> {
                    startActivity(Intent(this,Cart::class.java))
                }
                R.id.share ->{
                    val sendIntent : Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT,"Check out this : ")
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent,"Share via")
                    startActivity(shareIntent)
                    }
                R.id.orders -> {
                    startActivity(Intent(this, MyOrders::class.java))
                }
                }
            true
        }

        val images = arrayOf(R.drawable.wd,R.drawable.dm,R.drawable.crm)

        val sliderAdapter = ImageAdapter(this,images)
        binding.sliderView.setSliderAdapter(sliderAdapter)
        binding.sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        binding.sliderView.startAutoCycle()

        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.nav_open,R.string.nav_close)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.products.setOnClickListener(this)
        binding.aboutUs.setOnClickListener(this)
        binding.contactUs.setOnClickListener(this)
        binding.whatsappLink.setOnClickListener(this)
        binding.shopNow.setOnClickListener(this)
        binding.insta.setOnClickListener(this)
        binding.fb.setOnClickListener(this)
        binding.linked.setOnClickListener(this)
        binding.yt.setOnClickListener(this)

    }

    @DelicateCoroutinesApi
    private fun signOut() {
        Firebase.auth.signOut()
        startActivity(Intent(this,SignIn::class.java))
        finish()
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
            finishAffinity()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.products -> {
                Intent(this,ProductsPage::class.java).also { startActivity(it) }
            }
            R.id.about_us -> {
                Intent(this,AboutUs::class.java).also { startActivity(it) }
            }
            R.id.contact_us -> {
                Intent(this,ContactUs::class.java).also { startActivity(it) }
            }
            R.id.shopNow -> {
                startActivity(Intent(this,ProductsPage::class.java))
            }
            R.id.whatsappLink -> {
                val whatsappUrl = Uri
                    .parse("https://api.whatsapp.com/send/?phone=%2B917709266577&text&app_absent=0")
                startActivity(Intent(Intent.ACTION_VIEW,whatsappUrl))
            }
            R.id.fb -> {
                val facebookUrl = Uri.parse("https://www.facebook.com/DIGITRONLIFE")
                startActivity(Intent(Intent.ACTION_VIEW,facebookUrl))
            }
            R.id.insta -> {
                val instagramUrl = Uri.parse("https://www.instagram.com/digitronssoftwares1/")
                startActivity(Intent(Intent(Intent.ACTION_VIEW,instagramUrl)))
            }
            R.id.linked -> {
                val linkedinUrl = Uri.parse("https://www.linkedin.com/company/digitron-softwares-and-technology/")
                startActivity(Intent(Intent(Intent.ACTION_VIEW,linkedinUrl)))
            }
            R.id.yt -> {
                val youtubeUrl = Uri.parse("https://www.youtube.com/channel/UCojsSw92BTSIwS_KEqMbusQ")
                startActivity(Intent(Intent.ACTION_VIEW,youtubeUrl))
            }
        }
    }

    fun sliderView(view: android.view.View) {
        startActivity(Intent(this,ProductsPage::class.java))
    }

}