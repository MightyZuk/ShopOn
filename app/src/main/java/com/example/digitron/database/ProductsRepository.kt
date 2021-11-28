package com.example.digitron.database

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseUser

class ProductsRepository(private val productsDao: ProductsDao) {

    val allProducts: LiveData<List<ProductDetails>> = productsDao.showAllProducts()

    suspend fun addProduct(productsDetails: ProductDetails){
        productsDao.addProducts(productsDetails)
    }

    fun getProductsByTitle(title: String): ProductDetails{
        return productsDao.getProductByTitle(title)
    }


}