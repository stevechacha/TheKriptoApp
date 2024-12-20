package com.chachadev.appthe.presentation.screen.exchangeDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.chachadev.appthe.presentation.common.AppTopBar
import com.chachadev.appthe.presentation.screen.coin.AnimatedLoadingScreen

@Composable
fun ExchangeDetailScreen(
    id: String ,
    navigateBack:()-> Unit,
    viewModel: ExchangeDetailsViewModel = hiltViewModel()
) {
    val uiState by  viewModel.exchangeDetailUiState.collectAsState()

    LaunchedEffect(key1 = id) {
        viewModel.getExchangeDetails(id)
    }
    Scaffold(
        topBar = {
            AppTopBar(title = "ExchangeDetail", navigateBack = navigateBack)
        }

    ){  padding ->

        if(uiState.isLoading){
            AnimatedLoadingScreen()
        } else if (uiState.data !=null){
            Column (
                modifier = Modifier.fillMaxSize().padding(padding),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = uiState.data.toString())
            }
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