package com.example.orgsalura.ui.addProductsFragment

import androidx.lifecycle.ViewModel
import com.example.orgsalura.data.ProductsRepository
import com.example.orgsalura.data.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddProductsViewModel @Inject constructor(private val repository: ProductsRepository) :
    ViewModel() {

    fun fetchProducts() = repository.fetchProducts()

    fun addProduct(product: Product) = repository.addProduct(product = product)
}