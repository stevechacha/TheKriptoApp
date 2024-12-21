package com.chachadev.appthe.presentation.screen.exchange

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chachadev.appthe.core.domain.model.Exchanges
import com.chachadev.appthe.presentation.common.AppTopBar
import com.chachadev.appthe.presentation.common.AnimatedLoadingScreen

@Composable
fun ExchangeScreen(
    onNavigateToExchangeDetail:(String)-> Unit,
    viewModel: ExchangeViewModel = hiltViewModel()
) {
    val uiState by  viewModel.uiState.collectAsState()

    Scaffold(
       topBar = {
           AppTopBar(
               modifier = Modifier,
               title = "Exchanges",
               showNavigationBar = false,
               navigateBack = {}
           )
       }
    ) { padding->
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
                    ExchangeItem(
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
fun ExchangeItem(
    exchange: Exchanges,
    onClick: (String) -> Unit
) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier.fillMaxWidth()
            .clickable { exchange.id?.let { onClick(it) } }
            .clip(RoundedCornerShape(16.dp))
            .padding(16.dp)
            .background(colorScheme.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = exchange.name?.take(16) ?: "Anonymous",
                    style = typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
                Text(
                    text = if (exchange.active == true) "Status: Active" else "Status: Dormant",
                    style = typography.labelMedium.copy(
                        color = if (exchange.active == true) colorScheme.primary else colorScheme.secondary
                    )
                )
            }
        }

        Column(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text(
                text = exchange.description?.takeIf { it.isNotEmpty() }
                    ?: "No description available.",
                style = typography.bodyMedium,
                color = colorScheme.onSurface.copy(alpha = 0.6F)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = colorScheme.onSurface.copy(alpha = 0.1F), thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
        }
        // Stats Section
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MarketStatItem(title = "Adjusted Rank", value = exchange.adjustedRank ?: 0)
            MarketStatItem(title = "Reported Rank", value = exchange.reportedRank ?: 0)
            MarketStatItem(title = "Markets", value = exchange.markets ?: 0)
            MarketStatItem(title = "Currencies", value = exchange.currencies ?: 0)
        }

        // Links Section
        val links = exchange.exchangeLinks
        val validLinks = mapOf(
            "Twitter" to links?.twitter,
            "Website" to links?.website
        ).filter { it.value != null && it.value!!.isNotEmpty() }

        if (validLinks.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                validLinks.forEach { link ->
                    LinkItem(
                        linksPair = link,
                        onLinkClick = { uri -> uriHandler.openUri(uri[0]) }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}

@Composable
fun MarketStatItem(title: String, value: Int) {
    Column(
        modifier = Modifier.width(80.dp)
            .padding(horizontal = 4.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = typography.labelSmall.copy(
                fontWeight = FontWeight.SemiBold,
                color = colorScheme.onSurface.copy(alpha = 0.7F),
                textAlign = TextAlign.Center
            ),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(colorScheme.primary.copy(alpha = 0.1F)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value.toString(),
                style = typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = colorScheme.primary
                )
            )
        }
    }
}

@Composable
fun LinkItem(
    linksPair: Map.Entry<String, List<String>?>,
    onLinkClick: (List<String>) -> Unit
) {
    Card(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = colorScheme.surface,
                shape = RoundedCornerShape(50)
            )
            .clickable { onLinkClick(linksPair.value!!) }
            .padding(horizontal = 12.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = colorScheme.surface)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = when (linksPair.key) {
                    "Twitter" -> Icons.Default.Tag
                    else -> Icons.Default.Link
                },
                contentDescription = null,
                tint = colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = linksPair.key,
                style = typography.labelMedium.copy(color = colorScheme.primary)
            )
        }
    }
}



