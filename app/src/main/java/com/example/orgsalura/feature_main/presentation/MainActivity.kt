package com.example.orgsalura.feature_main.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.orgsalura.common.ui.theme.OrgsAluraTheme
import com.example.orgsalura.feature_main.presentation.addProductsFragment.AddProductsScreen
import com.example.orgsalura.feature_main.presentation.productsListFragment.ProductsListScreen
import com.example.orgsalura.feature_main.presentation.util.Screen
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
                    }
                }
            }
        }
    }
}