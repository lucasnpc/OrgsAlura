package com.example.orgsalura.feature_products.data.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.orgsalura.feature_products.data.repository.local.dao.ProductDao
import com.example.orgsalura.feature_products.domain.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "app_db"
    }

    abstract val productDao: ProductDao

}