package com.example.orgsalura.feature_main.presentation.addProductsFragment

import androidx.lifecycle.ViewModel
import com.example.orgsalura.feature_main.domain.model.Product
import com.example.orgsalura.feature_main.domain.useCase.ProductsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AddProductsViewModel @Inject constructor(private val productsUseCases: ProductsUseCases) :
    ViewModel() {

    private val _imageUrl = MutableStateFlow("")
    val imageUrl: StateFlow<String> = _imageUrl

    private val _openDialog = MutableStateFlow(false)
    val openDialog: StateFlow<Boolean> = _openDialog

    fun addProduct(product: Product) = productsUseCases.addProduct(product = product)

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