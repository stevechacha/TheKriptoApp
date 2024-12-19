package com.chachadev.appthe.core.domain.model

import kotlinx.serialization.Serializable

data class CoinDetails(
    val id: String?,
    val name: String?,
    val symbol: String?,
    val rank: Int?,
    val isNew: Boolean?,
    val isActive: Boolean?,
    val type: String?,
    val tags: List<Tag>?,
    val team: List<Team>?,
    val description: String?,
    val message: String?,
    val openSource: Boolean?,
    val startedAt: String?,
    val developmentStatus: String?,
    val links: Links?,
    val linksExtended: List<LinksExtended>?
)

data class Tag(
    val coinCounter: Int,
    val icoCounter: Int,
    val id: String,
    val name: String
)

data class Team(
    val id: String,
    val name: String,
    val position: String
)

data class WhitePaper(
    val link: String,
    val thumbnail: String
)

data class ContractModel(
    val contract: String,
    val platform: String,
    val type: String
)

data class Links(
    val explorer: List<String>?,
    val facebook: List<String>?,
    val reddit: List<String>?,
    val sourceCode: List<String>?,
    val website: List<String>?,
    val youtube: List<String>?
)

data class LinksExtended(
    val statsDTO: Stats?,
    val type: String,
    val url: String
)

data class Stats(
    val contributors: Int?,
    val stars: Int?,
    val subscribers: Int?
)

data class Parent(
    val id: String?,
    val name: String?,
    val symbol: String?
)