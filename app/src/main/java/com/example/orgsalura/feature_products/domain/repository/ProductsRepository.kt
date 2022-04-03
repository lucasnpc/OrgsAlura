package com.example.orgsalura.feature_products.domain.repository

import com.example.orgsalura.feature_products.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun addProduct(product: Product)

    fun fetchProducts(): Flow<List<Product>>

    fun getProductById(productId: Int): Product
}