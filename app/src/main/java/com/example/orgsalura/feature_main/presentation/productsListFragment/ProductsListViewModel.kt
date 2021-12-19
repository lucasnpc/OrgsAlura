package com.example.orgsalura.feature_main.presentation.productsListFragment

import androidx.lifecycle.ViewModel
import com.example.orgsalura.feature_main.domain.useCase.ProductsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(private val productsUseCases: ProductsUseCases) :
    ViewModel() {

    fun fetchProducts() = productsUseCases.getProducts()

}