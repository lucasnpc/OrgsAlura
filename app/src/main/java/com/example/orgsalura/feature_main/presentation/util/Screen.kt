package com.example.orgsalura.feature_main.presentation.util

sealed class Screen(val route: String){
    object AddProductsScreen: Screen("add_products_screen")
    object ProductsListScreen: Screen("products_list_screen")
}