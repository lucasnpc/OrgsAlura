package com.example.orgsalura.data

import com.example.orgsalura.data.model.Product

class ProductsRepository {

    fun addProduct(product: Product) = products.add(product)


    fun fetchProducts() = products

    companion object {
        private val products = ArrayList<Product>()
    }
}