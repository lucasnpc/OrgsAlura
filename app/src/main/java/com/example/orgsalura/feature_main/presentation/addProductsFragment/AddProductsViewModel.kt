package com.example.orgsalura.feature_main.presentation.addProductsFragment

import androidx.lifecycle.ViewModel
import com.example.orgsalura.feature_main.domain.model.Product
import com.example.orgsalura.feature_main.domain.useCase.ProductsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddProductsViewModel @Inject constructor(private val productsUseCases: ProductsUseCases) :
    ViewModel() {

    fun addProduct(product: Product) = productsUseCases.addProduct(product = product)

}