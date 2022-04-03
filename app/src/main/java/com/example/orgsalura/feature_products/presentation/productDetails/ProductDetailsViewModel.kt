package com.example.orgsalura.feature_products.presentation.productDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orgsalura.feature_products.domain.model.Product
import com.example.orgsalura.feature_products.domain.useCase.ProductsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val productsUseCases: ProductsUseCases,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _product = mutableStateOf(Product())
    val product: State<Product> = _product

    init {
        savedStateHandle.get<Int>("productId")?.let { id ->
            if (id != -1)
                getProductById(id)
        }
    }

    private fun getProductById(productId: Int) =
        viewModelScope.launch(Dispatchers.IO) {
            productsUseCases.getProductById(productId).also {
                delay(50)
                _product.value = it
            }
        }
}