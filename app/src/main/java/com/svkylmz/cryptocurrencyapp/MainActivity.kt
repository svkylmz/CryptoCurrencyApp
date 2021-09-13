package com.svkylmz.cryptocurrencyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.svkylmz.cryptocurrencyapp.ui.theme.CryptoCurrencyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyAppTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "crypto_list_screen") {
                    composable("crypto_list_screen") {
                        TODO("CryptoListScreen Will Be Here")
                    }
                    composable("crypto_detail_screen/{cryptoId}/{cryptoPrice}", arguments = listOf(
                        navArgument("cryptoId") { type = NavType.StringType },
                        navArgument("cryptoPrice") { type = NavType.StringType })
                    ) {
                        val cryptoId = remember { it.arguments?.getString("cryptoId") }
                        val cryptoPrice = remember { it.arguments?.getString("cryptoPrice") }
                        TODO("CryptoDetailScreen Will Be Here")
                    }
                }
            }
        }
    }
}