package com.example.orgsalura.feature_products.presentation.productsList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.orgsalura.feature_products.domain.model.Product
import com.example.orgsalura.feature_products.domain.useCase.ProductsUseCases
import com.example.orgsalura.feature_products.presentation.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(private val productsUseCases: ProductsUseCases) :
    ViewModel() {

    init {
        fetchProducts()
    }

    private val _state = mutableStateOf(ProductsState())
    val state: State<ProductsState> = _state

    private var fetchProductsJob: Job? = null

    private fun fetchProducts() {
        fetchProductsJob?.cancel()
        fetchProductsJob = productsUseCases.getProducts().onEach { products ->
            _state.value = state.value.copy(products = products)
        }.launchIn(viewModelScope)
    }

    fun openProductDetailsScreen(navController: NavController, product: Product) {
        navController.navigate(Screen.ProductDetailsScreen.route + "/${product.id}")
    }

}