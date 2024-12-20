package com.chachadev.appthe.presentation.screen.exchange

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chachadev.appthe.core.domain.model.Exchanges
import com.chachadev.appthe.presentation.screen.coin.AnimatedLoadingScreen

@Composable
fun ExchangeScreen(
    onNavigateToExchangeDetail:(String)-> Unit,
    viewModel: ExchangeViewModel = hiltViewModel()
) {
    val uiState by  viewModel.uiState.collectAsState()

    Scaffold { padding->
        if (uiState.isLoading){
            AnimatedLoadingScreen()
        } else if (uiState.exchanges.isNotEmpty()){
            LazyColumn(
                contentPadding = padding,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                items(uiState.exchanges) { exchange ->
                    ExchangeListItem(
                        exchange = exchange,
                        onClick = onNavigateToExchangeDetail
                    )
                }
            }

        } else {
            Text(text = uiState.errorMessage)
        }
    }

}

@Composable
fun ExchangeListItem(
    exchange: Exchanges,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable { exchange.id?.let { onClick(it) } },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for Exchange Logo
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = exchange.reportedRank.toString(), color = Color.White)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                exchange.name?.let {
                    Text(
                        text = it,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Text(
                    text = "Volume: ${exchange.quotes.values}",
                    color = Color.Gray
                )
            }
        }
    }
}

