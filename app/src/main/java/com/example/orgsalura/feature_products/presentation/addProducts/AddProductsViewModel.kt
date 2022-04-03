package com.example.orgsalura.feature_products.presentation.addProducts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orgsalura.feature_products.domain.model.Product
import com.example.orgsalura.feature_products.domain.useCase.ProductsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductsViewModel @Inject constructor(private val productsUseCases: ProductsUseCases) :
    ViewModel() {

    private val _imageUrl = MutableStateFlow("")
    val imageUrl: StateFlow<String> = _imageUrl

    private val _openDialog = MutableStateFlow(false)
    val openDialog: StateFlow<Boolean> = _openDialog

    fun addProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productsUseCases.addProduct(product = product)
        }
    }

    fun openAddImageDialog() {
        _openDialog.value = true
    }

    fun closeAlertDialog() {
        _openDialog.value = false
    }

    fun addImageUrl(url: String) {
        _imageUrl.value = url
    }

    fun cleanImageUrl() {
        _imageUrl.value = ""
    }

}