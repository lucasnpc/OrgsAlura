package com.example.orgsalura.feature_main.data.repository

import com.example.orgsalura.feature_main.domain.model.Product
import com.example.orgsalura.feature_main.domain.repository.ProductsRepository

class ProductsRepositoryImpl(private val products: ArrayList<Product>) : ProductsRepository {

    override fun addProduct(product: Product) {
        products.add(product)
    }

    override fun fetchProducts() = products
}