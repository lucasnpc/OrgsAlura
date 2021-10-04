package com.example.orgsalura.ui.productsListFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.orgsalura.R
import com.example.orgsalura.data.ProductsRepository
import com.example.orgsalura.data.model.Product

class ProductsListFragment : Fragment() {

    private val products by lazy {
        ProductsRepository().fetchProducts()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            ProductsList(
                products = products
            )
        }
    }

    @Preview
    @Composable
    private fun ProductsList(
        products: ArrayList<Product> = ArrayList()
    ) {
        Scaffold(
            topBar = {
                TopAppBar {
                    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                        val (text) = createRefs()
                        Text(
                            text = "Orgs",
                            fontSize = 17.sp,
                            modifier = Modifier.constrainAs(text) {
                                start.linkTo(parent.start, margin = 16.dp)
                            })
                    }
                }
            },
            content = {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(8.dp),
                ) {
                    items(products) {
                        ProductsRow(product = it, onRowClick = { product -> cardClick(product) })
                        Divider()
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { findNavController().navigate(R.id.add_products_fragment) }) {
                    Icon(Icons.Filled.Add, "")
                }
            }
        )
    }

    @Composable
    fun ProductsRow(product: Product, onRowClick: (Product) -> Unit) {
        Row(
            modifier = Modifier
                .clickable(onClick = { onRowClick(product) })
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(text = product.name, fontSize = 16.sp)
                Text(text = product.description, fontSize = 16.sp)
                Text(text = product.price.toString(), fontSize = 16.sp)
            }
        }
    }

    private fun cardClick(product: Product) {
        Log.e("clicke", product.toString())
    }
}

