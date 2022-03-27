package com.example.orgsalura.feature_products.presentation.productDetails

import androidx.lifecycle.ViewModel
import com.example.orgsalura.feature_products.domain.useCase.ProductsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(private val productsUseCases: ProductsUseCases): ViewModel() {

    fun getProductById(productId: String) = productsUseCases.getProductById(productId)
}