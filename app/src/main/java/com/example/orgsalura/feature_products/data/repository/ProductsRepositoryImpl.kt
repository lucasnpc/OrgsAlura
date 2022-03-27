package com.example.orgsalura.feature_products.data.repository

import com.example.orgsalura.feature_products.domain.model.Product
import com.example.orgsalura.feature_products.domain.repository.ProductsRepository

class ProductsRepositoryImpl(private val products: ArrayList<Product>) : ProductsRepository {

    override fun addProduct(product: Product) {
        products.add(product)
    }

    override fun fetchProducts() = products

    override fun getProductById(productId: String): Product =
        products.filter { product -> product.name == productId }[0]

}