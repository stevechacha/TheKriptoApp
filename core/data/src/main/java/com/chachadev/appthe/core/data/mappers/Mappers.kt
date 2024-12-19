package com.chachadev.appthe.core.data.mappers

import com.chachadev.appthe.core.data.network.dto.CoinDTO
import com.chachadev.appthe.core.data.network.dto.CoinDetailsDTO
import com.chachadev.appthe.core.data.network.dto.CoinDetailsLinksDTO
import com.chachadev.appthe.core.data.network.dto.ContractDTO
import com.chachadev.appthe.core.data.network.dto.ExchangeDTOLinks
import com.chachadev.appthe.core.data.network.dto.ExchangeDetailsDTO
import com.chachadev.appthe.core.data.network.dto.ExchangesDTO
import com.chachadev.appthe.core.data.network.dto.FiatDTO
import com.chachadev.appthe.core.data.network.dto.LinksExtendedDTO
import com.chachadev.appthe.core.data.network.dto.ParentDTO
import com.chachadev.appthe.core.data.network.dto.QuotesKeyDTO
import com.chachadev.appthe.core.data.network.dto.StatsDTO
import com.chachadev.appthe.core.data.network.dto.TagDTO
import com.chachadev.appthe.core.data.network.dto.TeamDTO
import com.chachadev.appthe.core.data.network.dto.WhitePaperDTO
import com.chachadev.appthe.core.domain.model.Coin
import com.chachadev.appthe.core.domain.model.CoinDetails
import com.chachadev.appthe.core.domain.model.ContractModel
import com.chachadev.appthe.core.domain.model.ExchangeDetails
import com.chachadev.appthe.core.domain.model.ExchangeLinks
import com.chachadev.appthe.core.domain.model.Exchanges
import com.chachadev.appthe.core.domain.model.Fiat
import com.chachadev.appthe.core.domain.model.Links
import com.chachadev.appthe.core.domain.model.LinksExtended
import com.chachadev.appthe.core.domain.model.Parent
import com.chachadev.appthe.core.domain.model.QuotesKey
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
    linksExtended = linksExtendedDto?.map { it.toLinksExtended() },
    message = message,
    name = name,
    openSource = openSource,
    rank = rank,
    startedAt = startedAt,
    symbol = symbol,
    tags = tagDTO?.map { it.toTag() },
    team = team?.map { it.toTeam()},
    type = type,
)
fun ExchangesDTO.toExchange() = Exchanges(
    active = active,
    adjustedRank = adjustedRank,
    apiStatus = apiStatus,
    currencies = currencies,
    description = description,
    fiats = fiatDTO?.map { it.toFiat() },
    id = id,
    lastUpdated = lastUpdated,
    exchangeLinks = exchangeDTOLinks?.toExchangeLinks(),
    markets = markets,
    marketsDataFetched = marketsDataFetched,
    message = message,
    name = name,
    quotesKey = quotesKeyDTO?.toQuoteKey(),
    reportedRank = reportedRank,
    websiteStatus = websiteStatus,
    confidenceScore = confidenceScore,
    sessionsPerMonth = sessionsPerMonth?.toInt()
)

fun ExchangeDetailsDTO.toExchangeDetail() = ExchangeDetails(
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
    quotes = quotesKeyDTO.toQuoteKey(),
    lastUpdated = lastUpdated,
    imgRev = imgRev,
    confidenceScore = confidenceScore
)


fun ExchangeDTOLinks.toExchangeLinks() = ExchangeLinks(
    twitter = twitter,
    website = twitter
)

fun QuotesKeyDTO.toQuoteKey() = QuotesKey(
    adjustedVolume24h = adjustedVolume24h,
    adjustedVolume30d = adjustedVolume30d,
    adjustedVolume7d = adjustedVolume7d,
    reportedVolume24h = reportedVolume24h,
    reportedVolume30d = reportedVolume30d,
    reportedVolume7d = reportedVolume7d
)

fun FiatDTO.toFiat() = Fiat(
    name = name,
    symbol = symbol
)
fun ContractDTO.toContact() = ContractModel(
    contract = contract,
    platform = platform,
    type = type
)
fun TagDTO.toTag() = Tag(
    id = id,
    icoCounter = icoCounter,
    coinCounter = coinCounter,
    name = name,
)

fun TeamDTO.toTeam() = Team(
    id = id,
    name = name,
    position = position
)

fun WhitePaperDTO.toWhitePaper() = WhitePaper(
    link = link,
    thumbnail  =thumbnail
)

fun CoinDetailsLinksDTO.toLinks() = Links(
    explorer = explorer,
    facebook = facebook,
    reddit = reddit,
    sourceCode = sourceCode,
    website = website,
    youtube = youtube
)

fun ParentDTO.toParent() = Parent(
    id = id,
    name = name,
    symbol = symbol
)

fun LinksExtendedDTO.toLinksExtended() = LinksExtended(
    statsDTO = statsDTO?.toStats(),
    type = type,
    url = url
)

fun StatsDTO.toStats() = Stats(
    contributors = contributors,
    stars = stars,
    subscribers = subscribers
)

