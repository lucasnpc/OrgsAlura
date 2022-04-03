package com.example.orgsalura.feature_products.data.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.orgsalura.feature_products.domain.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM Product")
    fun fetchAll(): Flow<List<Product>>

    @Query("SELECT * FROM Product WHERE id = :productId")
    fun getProductById(productId: Int): Product

    @Insert
    fun insertProduct(vararg product: Product)
}