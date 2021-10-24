package com.example.orgsalura.data

import com.example.orgsalura.data.model.Product

class ProductsRepository(private val products: ArrayList<Product>) {

    fun addProduct(product: Product) = products.add(product)

    fun fetchProducts() = products
}