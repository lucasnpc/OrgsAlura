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
import com.example.orgsalura.feature_main.domain.model.Product
import com.example.orgsalura.feature_main.presentation.util.extensions.brazilianCurrencyFormat

@Composable
fun ProductRow(product: Product) {
    Card(elevation = 8.dp) {
        Row(
            modifier = Modifier
                .clickable(onClick = { })
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "ProductImage",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(14.dp).weight(2f)) {
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
                Text(
                    text = product.price.brazilianCurrencyFormat(),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}
