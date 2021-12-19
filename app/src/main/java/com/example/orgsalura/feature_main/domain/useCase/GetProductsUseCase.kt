package com.example.orgsalura.feature_main.domain.useCase

import com.example.orgsalura.feature_main.domain.repository.ProductsRepository

class GetProductsUseCase(private val repository: ProductsRepository) {

    operator fun invoke() =
        repository.fetchProducts()

}