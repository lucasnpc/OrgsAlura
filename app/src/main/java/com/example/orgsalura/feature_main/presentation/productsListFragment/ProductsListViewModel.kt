package com.example.orgsalura.feature_main.presentation.productsListFragment

import androidx.lifecycle.ViewModel
import com.example.orgsalura.data.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(private val repository: ProductsRepository) :
    ViewModel() {

    fun fetchProducts() = repository.fetchProducts()

}