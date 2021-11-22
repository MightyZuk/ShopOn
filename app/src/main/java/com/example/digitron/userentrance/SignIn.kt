package com.example.digitron.userentrance

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        setContentView(view)

        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        myAuth = FirebaseAuth.getInstance()

        binding.forgotPassword.setOnClickListener(this)
        binding.sigInButton.setOnClickListener(this)
        binding.signUpLittle.setOnClickListener(this)
        binding.googleSignIn.setOnClickListener(this)
    }

    private fun signInWithEmail(email: String,password: String) {
        myAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    updateUi(myAuth.currentUser)
                    finish()
                }else{
                    Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()
                }
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
        loadingDialog()
        GlobalScope.launch(Dispatchers.IO) {
            val auth = myAuth.signInWithCredential(credential).await()
            val firebaseUser = auth.user
            withContext(Dispatchers.Main){
                updateUi(firebaseUser)
            }

        }
    }

    private fun loadingDialog() {
        dialog = Dialog(this)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.loading_dialog)
        dialog.create()
        dialog.show()
    }

    private fun updateUi(firebaseUser: FirebaseUser?) {
        if (firebaseUser != null){
            val user = UserDetails(firebaseUser.uid,firebaseUser.displayName!!,firebaseUser.email!!,firebaseUser.photoUrl.toString())
            val userDao = UserDao()
            userDao.addUser(user)
            startActivity(Intent(this,MainActivity::class.java))
            dialog.dismiss()
            finish()
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

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.googleSignIn -> {
                signIn()
            }
            R.id.forgotPassword -> {
                startActivity(Intent(this,ForgotPassword::class.java))
            }
            R.id.sigInButton -> {
                val user = myAuth.currentUser
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
                        signInWithEmail(email,password)
                    }
                }
            }
            R.id.signUpLittle -> {
                Intent(this,SignUp::class.java).also { startActivity(it) }
            }
        }
    }


}
