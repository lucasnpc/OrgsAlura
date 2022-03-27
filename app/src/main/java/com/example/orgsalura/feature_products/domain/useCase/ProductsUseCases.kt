package com.example.orgsalura.feature_products.domain.useCase

data class ProductsUseCases(
    val addProduct: AddProductUseCase,
    val getProducts: GetProductsUseCase,
    val getProductById: GetProductByIdUseCase
)