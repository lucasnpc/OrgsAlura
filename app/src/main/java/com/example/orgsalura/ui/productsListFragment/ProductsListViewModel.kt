package com.example.orgsalura.ui.productsListFragment

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.orgsalura.data.ProductsRepository
import com.example.orgsalura.data.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(private val repository: ProductsRepository) :
    ViewModel() {

    fun fetchProducts() = repository.fetchProducts()

    fun cardClick(product: Product) {
        Log.e("Click", product.toString())
    }
}