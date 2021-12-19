package com.example.orgsalura.feature_main.presentation.productsListFragment

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
import com.example.orgsalura.feature_main.presentation.productsListFragment.components.ProductRow
import com.example.orgsalura.feature_main.presentation.util.Screen

@Composable
fun ProductsListScreen(
    viewModel: ProductsListViewModel = hiltViewModel(),
    navController: NavController
) {
    val products = viewModel.fetchProducts()
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
                items(products) {
                    ProductRow(product = it)
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