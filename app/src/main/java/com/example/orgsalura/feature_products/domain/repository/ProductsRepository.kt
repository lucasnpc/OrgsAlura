package com.example.orgsalura.feature_products.domain.repository

import com.example.orgsalura.feature_products.domain.model.Product

interface ProductsRepository {

    fun addProduct(product: Product)

    fun fetchProducts(): ArrayList<Product>

    fun getProductById(productId: String): Product
}