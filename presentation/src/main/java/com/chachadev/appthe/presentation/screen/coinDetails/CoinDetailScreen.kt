package com.chachadev.appthe.presentation.screen.coinDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chachadev.appthe.core.domain.model.CoinDetails
import com.chachadev.appthe.presentation.common.AppTopBar

@Composable
fun CoinDetailScreen(
    id: String,
    navigateBack:()-> Unit,
    viewModel: CoinDetailsViewModel = hiltViewModel(),
) {
    val uiState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = id) {
        viewModel.getCoinDetails(id)
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "CoinDetails",
                navigateBack = navigateBack,
                showNavigationBar = true
            )
        }
    ) {  paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            uiState.coinDetails?.let {  coinDeDetails ->
                CoinDetailsComponent(coinDetails = coinDeDetails) }
        }
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