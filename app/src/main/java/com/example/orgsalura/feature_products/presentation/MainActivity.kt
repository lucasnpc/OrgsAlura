package com.example.orgsalura.feature_products.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.orgsalura.common.ui.theme.OrgsAluraTheme
import com.example.orgsalura.feature_products.presentation.addProducts.AddProductsScreen
import com.example.orgsalura.feature_products.presentation.productDetails.ProductDetailsScreen
import com.example.orgsalura.feature_products.presentation.productsList.ProductsListScreen
import com.example.orgsalura.feature_products.presentation.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrgsAluraTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ProductsListScreen.route
                    ) {
                        composable(route = Screen.ProductsListScreen.route) {
                            ProductsListScreen(navController = navController)
                        }
                        composable(route = Screen.AddProductsScreen.route) {
                            AddProductsScreen(navController = navController)
                        }
                        composable(
                            route = Screen.ProductDetailsScreen.route + "/{productId}",
                            arguments = listOf(
                                navArgument("productId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                })
                        ) {
                            ProductDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}