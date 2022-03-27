package com.example.orgsalura.feature_products.presentation.productsList

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.orgsalura.feature_products.domain.model.Product
import com.example.orgsalura.feature_products.domain.useCase.ProductsUseCases
import com.example.orgsalura.feature_products.presentation.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(private val productsUseCases: ProductsUseCases) :
    ViewModel() {

    fun fetchProducts() = productsUseCases.getProducts()

    fun openProductDetailsScreen(navController: NavController, product: Product) {
        navController.navigate(Screen.ProductDetailsScreen.route + "/${product.name}")
    }

}