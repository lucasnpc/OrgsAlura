package com.example.orgsalura.feature_main.domain.repository

import com.example.orgsalura.feature_main.domain.model.Product

interface ProductsRepository {
    
    fun addProduct(product: Product)

    fun fetchProducts(): ArrayList<Product>
}