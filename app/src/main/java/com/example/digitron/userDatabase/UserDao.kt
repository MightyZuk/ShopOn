package com.example.digitron.userDatabase

import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDao {
    private val db = FirebaseFirestore.getInstance()
    private val userCollection = db.collection("users")

    @DelicateCoroutinesApi
    fun addUser(user: UserDetails?){
        user.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(user!!.id).set(it!!)
            }
        }
    }

    fun getUserById(id: String): Task<DocumentSnapshot>{
        return userCollection.document(id).get()
    }
}