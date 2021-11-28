package com.example.digitron.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductDetails::class] , version = 1, exportSchema = false)
abstract class ProductsDatabase: RoomDatabase() {

    abstract fun productsDao(): ProductsDao

    companion object{
        @Volatile
        private var INSTANCE : ProductsDatabase? = null

        fun getDatabase(context: Context): ProductsDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductsDatabase::class.java,
                    "products_database").build()
                    INSTANCE = instance
                    return instance
            }
        }
    }
}