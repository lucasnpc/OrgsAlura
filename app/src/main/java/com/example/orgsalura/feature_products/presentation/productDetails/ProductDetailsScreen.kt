package com.example.orgsalura.feature_products.presentation.productDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.orgsalura.feature_products.presentation.productDetails.components.DetailsHeander

@Composable
fun ProductDetailsScreen(
    viewModel: ProductDetailsViewModel = hiltViewModel(),
    productId: String
) {
    val product = viewModel.getProductById(productId = productId)

    Scaffold {
        Column {
            DetailsHeander(product = product)
            Text(
                text = product.name, style = TextStyle(
                    color = Color.DarkGray, fontSize = 28.sp
                ), modifier = Modifier.padding(16.dp)
            )
            Text(
                text = product.description, style = TextStyle(
                    color = Color.Gray, fontSize = 20.sp
                ), modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}