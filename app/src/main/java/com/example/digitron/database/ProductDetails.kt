package com.example.digitron.database

import android.content.ClipDescription
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_details")
class ProductDetails(
    @PrimaryKey val id: Int,
    val image: Int,
    val title: String,
    val category: String,
    val description: String,
    val highlights: String,
    val price: Int) {
}