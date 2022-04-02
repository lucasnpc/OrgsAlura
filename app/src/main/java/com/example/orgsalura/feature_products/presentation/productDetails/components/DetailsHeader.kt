package com.example.orgsalura.feature_products.presentation.productDetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.orgsalura.R
import com.example.orgsalura.feature_products.domain.model.Product
import com.example.orgsalura.feature_products.presentation.util.extensions.brazilianCurrencyFormat

@Composable
fun DetailsHeander(product: Product) {
    Box(
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(data = product.imageUrl, builder = {
                error(R.drawable.add_screen_image_placeholder)
            }),
            contentDescription = "Product Image",
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Card(
                elevation = 10.dp,
                shape = RoundedCornerShape(25.dp)
            ) {
                Text(
                    text = product.price.brazilianCurrencyFormat(),
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}