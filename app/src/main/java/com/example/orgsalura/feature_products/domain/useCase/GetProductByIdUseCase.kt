package com.example.orgsalura.feature_products.domain.useCase

import com.example.orgsalura.feature_products.domain.repository.ProductsRepository

class GetProductByIdUseCase(private val repository: ProductsRepository) {

    operator fun invoke(productId: String)  = repository.getProductById(productId)
}