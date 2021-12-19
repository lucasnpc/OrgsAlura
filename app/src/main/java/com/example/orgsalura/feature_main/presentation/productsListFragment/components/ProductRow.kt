package com.example.orgsalura.feature_main.presentation.productsListFragment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.orgsalura.R
import com.example.orgsalura.data.model.Product

@Composable
fun ProductRow(product: Product) {
    Card(elevation = 8.dp) {
        Row(
            modifier = Modifier
                .clickable(onClick = { })
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "ProductImage",
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.h1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = product.price.toString(), style = MaterialTheme.typography.body2)
            }
        }
    }
}