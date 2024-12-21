package com.chachadev.appthe.core.data.mappers

import com.chachadev.appthe.core.data.network.dto.BlockchainServiceDTO
import com.chachadev.appthe.core.data.network.dto.CoinDTO
import com.chachadev.appthe.core.data.network.dto.CoinDetailsDTO
import com.chachadev.appthe.core.data.network.dto.CoinDetailsLinksDTO
import com.chachadev.appthe.core.data.network.dto.CoinTagDTO
import com.chachadev.appthe.core.data.network.dto.CoinTickerDTO
import com.chachadev.appthe.core.data.network.dto.ContractDTO
import com.chachadev.appthe.core.data.network.dto.CurrencyExchangeDTO
import com.chachadev.appthe.core.data.network.dto.EventDTO
import com.chachadev.appthe.core.data.network.dto.ExchangeCoinDTO
import com.chachadev.appthe.core.data.network.dto.ExchangeDTOLinks
import com.chachadev.appthe.core.data.network.dto.ExchangeMarketDTO
import com.chachadev.appthe.core.data.network.dto.ExchangeMarketQuoteDTO
import com.chachadev.appthe.core.data.network.dto.ExchangesDetailsDTO
import com.chachadev.appthe.core.data.network.dto.ExchangesDTO
import com.chachadev.appthe.core.data.network.dto.FiatDTO
import com.chachadev.appthe.core.data.network.dto.GlobalMarketStatsDTO
import com.chachadev.appthe.core.data.network.dto.LinksExtendedDTO
import com.chachadev.appthe.core.data.network.dto.ParentDTO
import com.chachadev.appthe.core.data.network.dto.QuoteDTO
import com.chachadev.appthe.core.data.network.dto.QuoteDetailsDTO
import com.chachadev.appthe.core.data.network.dto.SocialStatusDTO
import com.chachadev.appthe.core.data.network.dto.StatsDTO
import com.chachadev.appthe.core.data.network.dto.TeamDTO
import com.chachadev.appthe.core.data.network.dto.WhitePaperDTO
import com.chachadev.appthe.core.domain.model.BlockchainService
import com.chachadev.appthe.core.domain.model.Coin
import com.chachadev.appthe.core.domain.model.CoinDetails
import com.chachadev.appthe.core.domain.model.CoinTicker
import com.chachadev.appthe.core.domain.model.ContractModel
import com.chachadev.appthe.core.domain.model.CurrencyExchange
import com.chachadev.appthe.core.domain.model.Event
import com.chachadev.appthe.core.domain.model.ExchangeCoin
import com.chachadev.appthe.core.domain.model.ExchangeDetails
import com.chachadev.appthe.core.domain.model.ExchangeLinks
import com.chachadev.appthe.core.domain.model.ExchangeMarket
import com.chachadev.appthe.core.domain.model.ExchangeMarketQuote
import com.chachadev.appthe.core.domain.model.Exchanges
import com.chachadev.appthe.core.domain.model.Fiat
import com.chachadev.appthe.core.domain.model.GlobalMarketStats
import com.chachadev.appthe.core.domain.model.Links
import com.chachadev.appthe.core.domain.model.LinksExtended
import com.chachadev.appthe.core.domain.model.Parent
import com.chachadev.appthe.core.domain.model.Quote
import com.chachadev.appthe.core.domain.model.QuoteDetails
import com.chachadev.appthe.core.domain.model.SocialStatus
import com.chachadev.appthe.core.domain.model.Stats
import com.chachadev.appthe.core.domain.model.Tag
import com.chachadev.appthe.core.domain.model.Team
import com.chachadev.appthe.core.domain.model.WhitePaper

fun CoinDTO.toCoinDomain(): Coin {
    return Coin(
        id = id,
        name = name,
        symbol = symbol,
        isNew = isNew,
        isActive = isActive,
        type = type,
        rank = rank
    )
}

fun CoinDetailsDTO.toCoinDetailDomain() = CoinDetails(
    id = id,
    description = description,
    developmentStatus = developmentStatus,
    isActive = isActive,
    isNew = isNew,
    links = links?.toLinks(),
    linksExtended = linksExtended?.map { it.toLinksExtended() },
    message = message,
    name = name,
    openSource = openSource,
    rank = rank,
    startedAt = startedAt,
    symbol = symbol,
    tags = tags?.map { it.toTag() },
    team = team?.map { it.toTeam() },
    type = type,
)



fun ExchangesDTO.toExchange() = Exchanges(
    active = active,
    adjustedRank = adjustedRank,
    apiStatus = apiStatus,
    currencies = currencies,
    description = description,
    fiats = fiats?.map { it.toFiat() },
    id = id,
    lastUpdated = lastUpdated,
    exchangeLinks = exchangeDTOLinks?.toExchangeLinks(),
    markets = markets,
    marketsDataFetched = marketsDataFetched,
    message = message,
    name = name,
    quotes = quotes?.toQuoteKey(),
    reportedRank = reportedRank,
    websiteStatus = websiteStatus
)

fun ExchangesDetailsDTO.toExchangeDetail() = ExchangeDetails(
    id = id,
    name = name,
    description = description,
    active = active,
    websiteStatus = websiteStatus,
    apiStatus = apiStatus,
    message = message,
    links = exchangeDTOLinks?.toExchangeLinks(),
    marketsDataFetched = marketsDataFetched,
    adjustedRank = adjustedRank,
    reportedRank = reportedRank,
    currencies = currencies,
    markets = markets,
    fiats = fiats,
    quotes = quotes?.toQuoteKey(),
    lastUpdated = lastUpdated
)



private fun ExchangeDTOLinks.toExchangeLinks() = ExchangeLinks(
    twitter = twitter,
    website = twitter
)

private fun QuoteDetailsDTO.toQuoteKey() = QuoteDetails(
        reportedVolume24h = reportedVolume24h,
        adjustedVolume24h = adjustedVolume24h,
        reportedVolume7d = reportedVolume7d,
        adjustedVolume7d = adjustedVolume7d,
        reportedVolume30d = reportedVolume30d,
        adjustedVolume30d = adjustedVolume30d
    )


private fun FiatDTO.toFiat() = Fiat(
    name = name,
    symbol = symbol
)

private fun ContractDTO.toContact() = ContractModel(
    contract = contract,
    platform = platform,
    type = type
)

private fun CoinTagDTO.toTag() = Tag(
    id = id,
    icoCounter = icoCounter,
    coinCounter = coinCounter,
    name = name,
)

private fun TeamDTO.toTeam() = Team(
    id = id,
    name = name,
    position = position
)

private fun WhitePaperDTO.toWhitePaper() = WhitePaper(
    link = link,
    thumbnail = thumbnail
)

private fun CoinDetailsLinksDTO.toLinks() = Links(
    explorer = explorer,
    facebook = facebook,
    reddit = reddit,
    sourceCode = sourceCode,
    website = website,
    youtube = youtube
)

private fun ParentDTO.toParent() = Parent(
    id = id,
    name = name,
    symbol = symbol
)

private fun LinksExtendedDTO.toLinksExtended() = LinksExtended(
    statsDTO = stats?.toStats(),
    type = type,
    url = url
)

private fun StatsDTO.toStats() = Stats(
    contributors = contributors,
    stars = stars,
    subscribers = subscribers
)

fun BlockchainServiceDTO.toBlockChainService() = BlockchainService(
    id = id,
    name = name,
    coinCounter = coinCounter,
    icoCounter = icoCounter,
    description = description,
    type = type,
    coins = coins,
    icos = icos
)

private fun QuoteDTO.toQuote() = Quote(
    price = price,
    volume24h = volume24h,
    volume24hChange24h = volume24hChange24h,
    marketCap = marketCap,
    marketCapChange24h = marketCapChange24h,
    percentChange15m = marketCapChange24h,
    percentChange30m = percentChange30m,
    percentChange1h = percentChange1h,
    percentChange6h = percentChange6h,
    percentChange12h = percentChange12h,
    percentChange24h = percentChange24h,
    percentChange7d = percentChange7d,
    percentChange30d = percentChange30d,
    percentChange1y = percentChange1h,
    athPrice = athPrice,
    athDate = athDate,
    percentFromPriceAth = percentFromPriceAth
)

fun CoinTickerDTO.toCoinTicker() = CoinTicker(
    id = id,
    name = name,
    symbol = symbol,
    rank = rank,
    circulatingSupply = circulatingSupply,
    totalSupply = totalSupply,
    maxSupply = maxSupply,
    betaValue = betaValue,
    firstDataAt = firstDataAt,
    lastUpdated = lastUpdated,
    quotes = quotes.toQuote()
)

fun CurrencyExchangeDTO.toCurrencyExchange() = CurrencyExchange(
    baseCurrencyId = baseCurrencyId,
    baseCurrencyName = baseCurrencyName,
    basePriceLastUpdated = basePriceLastUpdated,
    quoteCurrencyId = quoteCurrencyId,
    quoteCurrencyName = quoteCurrencyName,
    quotePriceLastUpdated = quotePriceLastUpdated,
    amount = amount,
    price = price
)

fun EventDTO.toEvent() = Event(
    dateTo = dateTo,
    id = id,
    date = date,
    name = name,
    description = description,
    isConference = isConference,
    link = link,
    proofImageLink = proofImageLink
)

fun ExchangeCoinDTO.toExchangeCoin() = ExchangeCoin(
    id = id,
    name = name,
    fiats = fiats.map { it.toFiat() },
    adjustedVolume24hShare = adjustedVolume24hShare
)


fun ExchangeMarketDTO.toExchangeMarket() = ExchangeMarket(
    exchangeId = exchangeId,
    exchangeName = exchangeName,
    pair = pair,
    baseCurrencyId = baseCurrencyId,
    baseCurrencyName = baseCurrencyName,
    quoteCurrencyId = quoteCurrencyId,
    quoteCurrencyName = quoteCurrencyName,
    marketUrl = marketUrl,
    category = category,
    feeType = feeType,
    outlier = outlier,
    adjustedVolume24hShare = adjustedVolume24hShare,
    quotes = quotes.toExchangeMarketQuote(),
    lastUpdated = lastUpdated
)

private fun ExchangeMarketQuoteDTO.toExchangeMarketQuote() = ExchangeMarketQuote(
    price = price,
    volume24h = volume24h
)

fun GlobalMarketStatsDTO.toGlobalMarketStats() = GlobalMarketStats(
    marketCapUsd = marketCapUsd,
    volume24hUsd = volume24hUsd,
    bitcoinDominancePercentage = bitcoinDominancePercentage,
    cryptocurrenciesNumber = cryptocurrenciesNumber,
    marketCapAthValue = marketCapAthValue,
    marketCapAthDate = marketCapAthDate,
    volume24hAthValue = volume24hAthValue,
    volume24hAthDate = volume24hAthDate,
    marketCapChange24h = marketCapChange24h,
    volume24hChange24h = volume24hChange24h,
    lastUpdated = lastUpdated
)

fun SocialStatusDTO.toSocialStatus() = SocialStatus(
    date = date,
    userName = userName,
    userImageLink = userImageLink,
    status = status,
    isRetweet = isRetweet,
    retweetCount = retweetCount,
    likeCount = likeCount,
    statusLink = statusLink,
    statusId = statusId,
    mediaLink = mediaLink,
    youtubeLink = userImageLink
)
