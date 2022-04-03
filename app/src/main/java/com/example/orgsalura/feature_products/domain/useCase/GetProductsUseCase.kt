package com.example.orgsalura.feature_products.domain.useCase

import com.example.orgsalura.feature_products.domain.model.Product
import com.example.orgsalura.feature_products.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val repository: ProductsRepository) {

    operator fun invoke(): Flow<List<Product>> =
        repository.fetchProducts()

}