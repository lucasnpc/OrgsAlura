package com.example.orgsalura.feature_products.presentation.productDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ProductDetailsScreen(
    viewModel: ProductDetailsViewModel = hiltViewModel(),
    navController: NavController, productId: String
) {
    val product = viewModel.getProductById(productId = productId)

    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Text(text = product.imageUrl)
                Text(text = product.description)
                Text(text = product.name)
                Text(text = product.price.toString())
            }
        }
    }


}