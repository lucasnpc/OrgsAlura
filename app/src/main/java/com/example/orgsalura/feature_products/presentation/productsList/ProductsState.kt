package com.example.orgsalura.feature_products.presentation.productsList

import com.example.orgsalura.feature_products.domain.model.Product

data class ProductsState(
    val products: List<Product> = emptyList()
)
