package com.example.orgsalura.feature_products.presentation.productsList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.orgsalura.feature_products.presentation.productsList.components.ProductRow
import com.example.orgsalura.feature_products.presentation.util.Screen

@Composable
fun ProductsListScreen(
    viewModel: ProductsListViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
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
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
            ) {
                items(state.products) {
                    ProductRow(
                        product = it
                    ) { viewModel.openProductDetailsScreen(navController = navController, it) }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.AddProductsScreen.route) }) {
                Icon(Icons.Filled.Add, "Add item")
            }
        }
    )
}