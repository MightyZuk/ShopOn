package com.example.digitron.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_details")
class ProductDetails(
    @PrimaryKey val id: Int? = 1,
    val image: Int? = 0,
    val title: String? = "",
    val category: String? = "",
    val description: String? = "",
    val highlights: String? = "",
    val price: Int? = null,
    var minQuantity : Int? = 1,
    val maxQuantity: Int? = 1)