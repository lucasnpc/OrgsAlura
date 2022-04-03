package com.example.orgsalura.feature_products.data.repository

import com.example.orgsalura.feature_products.data.repository.local.dao.ProductDao
import com.example.orgsalura.feature_products.domain.model.Product
import com.example.orgsalura.feature_products.domain.repository.ProductsRepository

class ProductsRepositoryImpl(private val db: ProductDao) : ProductsRepository {

    override fun addProduct(product: Product) {
        db.insertProduct(product)
    }

    override fun fetchProducts() = db.fetchAll()

    override fun getProductById(productId: Int): Product =
        db.getProductById(productId)

}