package com.example.digitron.userentrance

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.digitron.MainActivity
import com.example.digitron.ProductsPage
import com.example.digitron.R
import com.example.digitron.databinding.ActivityMainBinding
import com.example.digitron.databinding.ActivitySignInBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import kotlin.time.Duration.Companion.days

@DelicateCoroutinesApi
class SignIn : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var myAuth: FirebaseAuth
    private val RC_SIGN_IN = 0
    private lateinit var binding: ActivitySignInBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = null
        setContentView(view)

        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        myAuth = Firebase.auth

        binding.googleSignIn.setOnClickListener{
            signIn()
        }

        binding.sigInButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
//            if (binding.username.text.toString() == user && binding.password.text.toString() == pass){
//                Intent(this,MainActivity::class.java).also { startActivity(it) }
//            }else if (binding.username.text.toString() != user && binding.password.text.toString() == pass){
//                Toast.makeText(this,"Please Enter correct username",Toast.LENGTH_SHORT).show()
//            }else if (binding.username.text.toString() == user && binding.password.text.toString() != pass){
//                Toast.makeText(this,"Please Enter correct password",Toast.LENGTH_SHORT).show()
//            }else if(binding.username.text.isEmpty() && binding.password.text!!.isEmpty()){
//                TODO()
//            }else{
//                Toast.makeText(this,"Please enter correct username and password",Toast.LENGTH_SHORT).show()
//            }
        }

        binding.signUpLittle.setOnClickListener {
            Intent(this,SignUp::class.java).also { startActivity(it) }
        }
    }

    private fun signIn() {
        val intent = googleSignInClient.signInIntent
        startActivityForResult(intent,RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>?) {
        try {
            val account = completedTask?.getResult(ApiException::class.java)
            firebaseAuthWithGoogle(account?.idToken)
        }catch (e: ApiException){
            Log.d("error",e.toString())
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String?) {
        val credential = GoogleAuthProvider.getCredential(idToken,null)
        binding.textView4.visibility = View.GONE
        binding.textView8.visibility = View.GONE
        binding.googleSignIn.visibility = View.GONE
        binding.imageView2.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
        binding.username.visibility = View.GONE
        binding.password.visibility = View.GONE
        binding.forgotPassword.visibility = View.GONE
        binding.sigInButton.visibility = View.GONE
        binding.signUpLittle.visibility = View.GONE
        binding.textView5.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE
        GlobalScope.launch(Dispatchers.IO) {
            val auth = myAuth.signInWithCredential(credential).await()
            val firebaseUser = auth.user
            withContext(Dispatchers.Main){
                updateUi(firebaseUser)
            }

        }
    }

    private fun updateUi(firebaseUser: FirebaseUser?) {
        if (firebaseUser != null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }else{
            binding.textView4.visibility = View.VISIBLE
            binding.textView8.visibility = View.VISIBLE
            binding.googleSignIn.visibility = View.VISIBLE
            binding.imageView2.visibility = View.VISIBLE
            binding.progressBar.visibility = View.VISIBLE
            binding.username.visibility = View.VISIBLE
            binding.password.visibility = View.VISIBLE
            binding.forgotPassword.visibility = View.VISIBLE
            binding.sigInButton.visibility = View.VISIBLE
            binding.signUpLittle.visibility = View.VISIBLE
            binding.textView5.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onStart() {
        super.onStart()
        val current = myAuth.currentUser
        updateUi(current)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}
