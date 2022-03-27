package com.example.orgsalura.feature_products.presentation.addProducts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.orgsalura.R
import com.example.orgsalura.feature_products.presentation.addProducts.AddProductsViewModel

@Composable
fun AddImageAlertDialog(viewModel: AddProductsViewModel) {
    AlertDialog(
        onDismissRequest = {
            viewModel.closeAlertDialog()
        },
        title = {
            Image(
                painter = rememberImagePainter(
                    data = viewModel.imageUrl.value,
                    builder = {
                        crossfade(1000)
                        placeholder(R.drawable.add_screen_image_placeholder)
                        error(R.drawable.add_screen_image_placeholder)
                    }),
                contentDescription = "Add Image Placeholder",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        },
        text = {
            OutlinedTextField(
                value = viewModel.imageUrl.value,
                onValueChange = { viewModel.addImageUrl(it) },
                label = {
                    Text(
                        text = "URL da Imagem",
                        style = MaterialTheme.typography.body1
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
                textStyle = MaterialTheme.typography.body1
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    viewModel.closeAlertDialog()
                }
            ) {
                Text("CONFIRMAR")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    viewModel.cleanImageUrl()
                    viewModel.closeAlertDialog()
                }
            ) {
                Text("CANCELAR")
            }
        }
    )

}