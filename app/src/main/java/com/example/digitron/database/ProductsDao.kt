package com.example.digitron.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProducts(productDetails: ProductDetails)

    @Query("SELECT * FROM products_details ORDER BY id ASC")
    fun showAllProducts(): LiveData<List<ProductDetails>>

}