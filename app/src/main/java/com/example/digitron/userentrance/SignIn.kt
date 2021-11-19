package com.example.digitron.userentrance

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.digitron.MainActivity
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

@DelicateCoroutinesApi
class SignIn : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN: Int = 123

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = null
        setContentView(view)

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this,gso)

        binding.googleSignIn.setOnClickListener{
            signIn()
        }

        binding.sigInButton.setOnClickListener {
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

    private fun signIn(){
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

    private fun handleSignInResult(task: Task<GoogleSignInAccount>) {
        val account = task.getResult(ApiException::class.java)!!
        firebaseAuthWithGoogle(account.idToken!!)
    }

    private fun firebaseAuthWithGoogle(idToken: String?) {
        val credential = GoogleAuthProvider.getCredential(idToken,null)

        GlobalScope.launch(Dispatchers.IO) {
            val myAuth = auth.signInWithCredential(credential).await()
            val firebaseUser = myAuth.user
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
        }
    }

}
