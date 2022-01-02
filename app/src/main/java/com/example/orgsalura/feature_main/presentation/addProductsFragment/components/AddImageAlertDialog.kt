package com.example.orgsalura.feature_main.presentation.addProductsFragment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.orgsalura.R

@Composable
fun AddImageAlertDialog(openDialog: MutableState<Boolean>, imageUrl: MutableState<String>) {
    AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        text = {
            Column {
                Box(contentAlignment = Alignment.TopEnd) {
                    Image(
                        painter = rememberImagePainter(
                            data = imageUrl.value,
                            builder = {
                                crossfade(2000)
                                placeholder(R.drawable.add_screen_image_placeholder)
                                error(R.drawable.add_screen_image_placeholder)
                            }),
                        contentDescription = "Add Image Placeholder",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                    Button(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "fuck you")
                        Text(text = "Carregar", style = MaterialTheme.typography.body1)
                    }
                }
                OutlinedTextField(
                    value = imageUrl.value,
                    onValueChange = { imageUrl.value = it },
                    label = {
                        Text(
                            text = "URL da Imagem",
                            style = MaterialTheme.typography.body1
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
                    textStyle = MaterialTheme.typography.body1
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
                }
            ) {
                Text("CONFIRMAR")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
                }
            ) {
                Text("CANCELAR")
            }
        }
    )

}