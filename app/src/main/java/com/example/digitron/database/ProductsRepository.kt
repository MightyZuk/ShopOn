package com.example.digitron.database

import androidx.lifecycle.LiveData

class ProductsRepository(private val productsDao: ProductsDao) {

    val allProducts: LiveData<List<ProductDetails>> = productsDao.showAllProducts()

    suspend fun addProduct(productsDetails: ProductDetails){
        productsDao.addProducts(productsDetails)
    }
}