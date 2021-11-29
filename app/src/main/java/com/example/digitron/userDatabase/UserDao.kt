package com.example.digitron.userDatabase

import android.graphics.BitmapFactory
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.navOptions
import com.example.digitron.database.ProductDetails
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.HashMap

class UserDao {
    private val db = FirebaseFirestore.getInstance()
    private val userCollection = db.collection("users")

    @DelicateCoroutinesApi
    fun addUser(user: UserDetails?){
        user.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(user!!.name).set(it!!)
            }
        }
    }

    fun getUserById(id: String): Task<DocumentSnapshot>{
        return userCollection.document(id).get()
    }

    @DelicateCoroutinesApi
    fun updateCartItems(list: HashMap<String,ProductDetails>,title: String){
        GlobalScope.launch(Dispatchers.IO) {
            userCollection.document(Firebase.auth.currentUser!!.displayName.toString()).collection("cartItems")
                .document(title).set(list)
        }
    }

    @DelicateCoroutinesApi
    fun deleteUser(user: FirebaseUser?){
        user.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(user?.displayName.toString()).delete()
            }
        }
    }

}