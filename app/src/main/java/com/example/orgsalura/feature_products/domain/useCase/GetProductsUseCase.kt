package com.example.orgsalura.feature_products.domain.useCase

import com.example.orgsalura.feature_products.domain.repository.ProductsRepository

class GetProductsUseCase(private val repository: ProductsRepository) {

    operator fun invoke() =
        repository.fetchProducts()

}