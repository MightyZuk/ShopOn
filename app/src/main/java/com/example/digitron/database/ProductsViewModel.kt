package com.example.digitron.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsViewModel(application: Application): AndroidViewModel(application) {

    private val allProductsDetails: LiveData<List<ProductDetails>>
    private val repository: ProductsRepository

    init {
        val productsDao = ProductsDatabase.getDatabase(application).productsDao()
        repository = ProductsRepository(productsDao)
        allProductsDetails = repository.allProducts
    }

    fun addProducts(productsDetails: ProductDetails){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProduct(productsDetails)
        }
    }

    fun getProductByTitle(title: String): ProductDetails{
        return repository.getProductsByTitle(title)
    }


}