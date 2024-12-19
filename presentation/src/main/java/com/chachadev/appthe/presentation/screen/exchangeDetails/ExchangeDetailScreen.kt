package com.chachadev.appthe.presentation.screen.exchangeDetails

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ExchangeDetailScreen(
    id: String ,
    viewModel: ExchangeDetailsViewModel = hiltViewModel()
) {
    val uiState by  viewModel.exchangeDetailUiState.collectAsState()

    LaunchedEffect(key1 = id) {
        viewModel.getExchangeDetails(id)
    }

    if (uiState.isLoading){
        CircularProgressIndicator()
    } else if (uiState.data !=null){
        Text(text = uiState.data.toString())
    } else {
        Text(text = uiState.errorMessage)
    }

}