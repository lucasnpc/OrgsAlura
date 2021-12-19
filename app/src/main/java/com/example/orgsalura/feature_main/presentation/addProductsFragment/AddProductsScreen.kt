package com.example.orgsalura.feature_main.presentation.addProductsFragment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.orgsalura.data.model.Product

@Composable
fun AddProductsScreen(
    viewModel: AddProductsViewModel = hiltViewModel(),
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar {
                ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                    val (text) = createRefs()
                    Text(
                        text = "Orgs",
                        modifier = Modifier.constrainAs(text) {
                            start.linkTo(parent.start, margin = 16.dp)
                        },
                        style = MaterialTheme.typography.h2
                    )
                }
            }
        },
        content = {
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                var name by remember { mutableStateOf("") }
                var description by remember { mutableStateOf("") }
                var price by remember { mutableStateOf("") }
                Column {
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Nome") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Descrição") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = price,
                        onValueChange = { price = it },
                        label = { Text("Valor") },
                        modifier = Modifier
                            .fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                Button(
                    onClick = {
                        viewModel.addProduct(
                            Product(
                                name = name,
                                description = description,
                                price = if (price.isNotBlank()) price.toDouble() else 0.0
                            )
                        )
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth(),
                    content = { Text(text = "Salvar", fontSize = 16.sp) }
                )
            }
        }
    )
}