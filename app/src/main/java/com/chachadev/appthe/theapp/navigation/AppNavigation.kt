package com.chachadev.appthe.theapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.chachadev.appthe.core.data.network.dto.CoinDetailsDTO
import com.chachadev.appthe.core.data.network.dto.ExchangeDetailsDTO
import com.chachadev.appthe.core.domain.model.CoinDetails
import com.chachadev.appthe.presentation.screen.coin.CoinListScreen
import com.chachadev.appthe.presentation.screen.coinDetails.CoinDetailScreen
import com.chachadev.appthe.presentation.screen.exchange.ExchangeScreen
import com.chachadev.appthe.presentation.screen.exchangeDetails.ExchangeDetailScreen
import kotlinx.serialization.Serializable


@Serializable
object  CoinList

@Serializable
object ExchangeList

@Serializable
data class CoinDetailRoute(val id: String)
@Serializable
data class ExchangeDetailsRoute(val id: String)

@Composable
fun AppNavigation(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = CoinList){
        composable<CoinList> {
            CoinListScreen(
                onNavigateToCoinDetail = { coinId ->
                    navController.navigate(CoinDetailRoute(coinId))
                }
            )
        }

        composable<CoinDetailRoute> { backStackEntry ->
            val coinDetail: CoinDetailsDTO = backStackEntry.toRoute()
            coinDetail.name?.let {
                CoinDetailScreen(
                    id = it,
                )
            }
        }

        composable<ExchangeList> {
            ExchangeScreen(
                onNavigateToExchangeDetail = { id ->
                    navController.navigate(ExchangeDetailsRoute(id))
                }
            )
        }

        composable<ExchangeDetailsRoute> { backStackEntry ->
            val exchangeDetails: ExchangeDetailsDTO = backStackEntry.toRoute()
            ExchangeDetailScreen(id =exchangeDetails.id)
        }

    }
}
