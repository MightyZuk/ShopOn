package com.example.digitron.userentrance

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toIcon
import com.example.digitron.MainActivity
import com.example.digitron.R
import com.example.digitron.databinding.ActivitySignInBinding
import com.example.digitron.userDatabase.UserDao
import com.example.digitron.userDatabase.UserDetails
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
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await

@DelicateCoroutinesApi
class SignIn : AppCompatActivity(), View.OnClickListener {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var myAuth: FirebaseAuth
    private val RC_SIGN_IN = 0
    private lateinit var binding: ActivitySignInBinding
    private lateinit var dialog: Dialog

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        supportActionBar?.title = null
        window.statusBarColor = ContextCompat.getColor(this, R.color.red)
        setContentView(view)

        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        dialog = Dialog(this)
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        myAuth = Firebase.auth
        binding.forgotPassword.setOnClickListener(this)
        binding.sigInButton.setOnClickListener(this)
        binding.signUpLittle.setOnClickListener(this)
        binding.googleSignIn.setOnClickListener(this)


    }

    override fun onStart() {
        super.onStart()
        val user = myAuth.currentUser
        if (user != null && user.isEmailVerified){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }


    private fun loadingDialog() {
        dialog = Dialog(this)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.loading_dialog)
        dialog.create()
        dialog.show()
    }


    override fun onBackPressed() {
        finishAffinity()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.googleSignIn -> {
                loadingDialog()
                signIn()
            }
            R.id.forgotPassword -> {
                startActivity(Intent(this,ForgotPassword::class.java))
            }
            R.id.sigInButton -> {
                val email = binding.username.text.toString().trim()
                val password = binding.password.text.toString().trim()
                when {
                    email.isEmpty() -> {
                        binding.username.requestFocus()
                        binding.username.error = "Required"
                    }
                    !Patterns.EMAIL_ADDRESS.matcher(email).matches() ->{
                        binding.username.error = "Please enter valid email"
                        binding.username.requestFocus()
                    }
                    password.length < 6 -> {
                        binding.password.error = "Password should be more than 8 characters"
                        binding.password.requestFocus()
                    }
                    password.isEmpty() -> {
                        binding.password.requestFocus()
                        binding.password.error = "Required"
                    }
                    else -> {
                        loadingDialog()
                        signInWithEmail(email,password)
                    }
                }
            }
            R.id.signUpLittle -> {
                Intent(this,SignUp::class.java).also { startActivity(it) }
            }
        }
    }

    private fun signInWithEmail(email: String, password: String) {
        myAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    if (myAuth.currentUser!!.isEmailVerified){
                        startActivity(Intent(this, MainActivity::class.java))
                    }else{
                        Toast.makeText(this,"Please wait for email verification",Toast.LENGTH_SHORT).show()
                    }
                    dialog.dismiss()
                }else{
                    Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent,RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        GlobalScope.launch(Dispatchers.IO) {
            val auth = myAuth.signInWithCredential(credential).await()
            val firebaseUser = auth.user
            withContext(Dispatchers.Main) {
                updateUI(firebaseUser)
            }
        }

    }

    private fun updateUI(firebaseUser: FirebaseUser?) {
        if(firebaseUser != null) {
            val user = UserDetails(firebaseUser.uid,
                firebaseUser.displayName.toString(),
                firebaseUser.email.toString())

            val usersDao = UserDao()
            usersDao.addUser(user)

            val mainActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
            dialog.dismiss()
            finish()
        }
    }


}
