package com.chachadev.appthe.presentation.screen.coinDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.chachadev.appthe.core.domain.model.CoinDetails

@Composable
fun CoinDetailScreen(
    id: String,
    viewModel: CoinDetailsViewModel = hiltViewModel(),
) {
    val uiState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = id) {
        viewModel.getCoinDetails(id)
    }

    Column {
        uiState.coinDetails?.let {  coinDeDetails ->
            CoinDetailsComponent(coinDetails = coinDeDetails) }
    }

}

@Composable
fun CoinDetailsComponent(
    modifier: Modifier = Modifier,
    coinDetails: CoinDetails?
) {
    Column {
        if (coinDetails != null) {
            coinDetails.id?.let { Text(text = it) }
        }
        if (coinDetails != null) {
            coinDetails.description?.let { Text(text = it) }
        }

        if (coinDetails != null) {
            Text(text = coinDetails.isActive.toString())
        }
    }

}