package com.example.digitron.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.google.firebase.auth.FirebaseUser

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProducts(productDetails: ProductDetails)

    @Query("SELECT * FROM products_details ORDER BY title ASC")
    fun showAllProducts(): LiveData<List<ProductDetails>>

    @Query("SELECT * FROM products_details WHERE title LIKE :title")
    fun getProductByTitle(title: String): ProductDetails


}