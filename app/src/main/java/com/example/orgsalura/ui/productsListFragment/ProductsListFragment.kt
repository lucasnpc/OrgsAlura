package com.example.orgsalura.ui.productsListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.orgsalura.R
import com.example.orgsalura.data.model.Product
import com.example.orgsalura.ui.addProductsFragment.AddProductsViewModel
import com.example.orgsalura.ui.theme.OrgsAluraTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsListFragment : Fragment() {

    private val viewModel: ProductsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            OrgsAluraTheme {
                ProductsList(
                    products = viewModel.fetchProducts()
                )
            }
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
                        ProductsRow(product = it)
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
    fun ProductsRow(product: Product) {
        Card(elevation = 8.dp) {
            Row(
                modifier = Modifier
                    .clickable(onClick = { viewModel.cardClick(product) })
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
}

