package com.chachadev.appthe.theapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.chachadev.appthe.presentation.screen.coin.CoinListScreen
import com.chachadev.appthe.presentation.screen.coinDetails.CoinDetailScreen
import com.chachadev.appthe.presentation.screen.currencyExchange.CurrencyExchangeScreen
import com.chachadev.appthe.presentation.screen.exchange.ExchangeScreen
import com.chachadev.appthe.presentation.screen.exchangeDetails.ExchangeDetailScreen
import kotlinx.serialization.Serializable


@Serializable
object  CoinListRoute

@Serializable
object ExchangeListRoute

@Serializable
object CurrencyExchangeRoute

@Serializable
data class CoinDetailRoute(val id: String)

@Serializable
data class ExchangeDetailsRoute(val id: String)

@Composable
fun AppNavigation(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = CoinListRoute){
        composable<CoinListRoute> {
            CoinListScreen(
                onNavigateToCoinDetail = { coinId ->
                    navController.navigate(CoinDetailRoute(coinId))
                }
            )
        }

        composable<CoinDetailRoute> { backStackEntry ->
            val coinDetail: CoinDetailRoute = backStackEntry.toRoute<CoinDetailRoute>()
            CoinDetailScreen(
                id = coinDetail.id,
                navigateBack = { navController.popBackStack()}
            )
        }

        composable<ExchangeListRoute> {
            ExchangeScreen(
                onNavigateToExchangeDetail = { id ->
                    navController.navigate(ExchangeDetailsRoute(id))
                }
            )
        }

        composable<ExchangeDetailsRoute> { backStackEntry ->
            val exchangeDetails: ExchangeDetailsRoute = backStackEntry.toRoute<ExchangeDetailsRoute>()
            ExchangeDetailScreen(
                id =exchangeDetails.id,
                navigateBack = { navController.popBackStack()}
            )
        }

        composable<CurrencyExchangeRoute> {
            CurrencyExchangeScreen()
        }



    }
}
