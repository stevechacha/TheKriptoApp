package com.chachadev.appthe.presentation.screen.exchangeDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.chachadev.appthe.core.domain.model.ExchangeDetails
import com.chachadev.appthe.presentation.common.AppTopBar
import com.chachadev.appthe.presentation.common.AnimatedLoadingScreen

@Composable
fun ExchangeDetailScreen(
    id: String,
    navigateBack: () -> Unit,
    viewModel: ExchangeDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.exchangeDetailUiState.collectAsState()

    LaunchedEffect(key1 = id) {
        viewModel.getExchangeDetails(id)
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "ExchangeDetail",
                navigateBack = navigateBack,
                showNavigationBar = true
            )
        }
    ) { padding ->
        if (uiState.isLoading) {
            AnimatedLoadingScreen()
        } else if (uiState.data != null) {
            ExchangeDetailsComponent(
                modifier = Modifier.padding(padding),
                exchangeDetails = uiState.data
            )
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = uiState.errorMessage)

            }
        }
    }
}

@Composable
fun ExchangeDetailsComponent(
    modifier: Modifier = Modifier,
    exchangeDetails: ExchangeDetails?
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = exchangeDetails?.id.toString())
        Text(text = exchangeDetails?.name.toString())
        Text(text = exchangeDetails?.description.toString())
    }
}