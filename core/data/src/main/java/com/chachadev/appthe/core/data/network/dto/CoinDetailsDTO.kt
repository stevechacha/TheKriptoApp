package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailsDTO(
    val id: String,
    val name: String,
    val symbol: String,
    val parent: ParentDTO?, // Added parent
    val rank: Int,
    @SerialName("is_new") val isNew: Boolean,
    @SerialName("is_active") val isActive: Boolean,
    val type: String,
    val tags: List<CoinTagDTO>?,
    val team: List<TeamDTO>?,
    val description: String?,
    val message: String?,
    @SerialName("open_source") val openSource: Boolean,
    @SerialName("hardware_wallet") val hardwareWallet: Boolean,
    @SerialName("started_at") val startedAt: String?,
    @SerialName("development_status") val developmentStatus: String?,
    @SerialName("proof_type") val proofType: String?,
    @SerialName("org_structure") val orgStructure: String?,
    @SerialName("hash_algorithm") val hashAlgorithm: String?,
    val contracts: List<ContractDTO>?, // Added contracts
    val links: CoinDetailsLinksDTO?,
    @SerialName("links_extended") val linksExtended: List<LinksExtendedDTO>?,
    @SerialName("whitepaper") val whitePaper: WhitePaperDTO?, // Fixed field name
    @SerialName("first_data_at") val firstDataAt: String?,
    @SerialName("last_data_at") val lastDataAt: String?
)


@Serializable
data class CoinTagDTO(
    @SerialName("coin_counter") val coinCounter: Int,
    @SerialName("ico_counter") val icoCounter: Int,
    val id: String,
    val name: String
)

@Serializable
data class TeamDTO(
    val id: String,
    val name: String,
    val position: String
)

@Serializable
data class ContractDTO(
    val contract: String,
    val platform: String,
    val type: String
)

@Serializable
data class CoinDetailsLinksDTO(
    val explorer: List<String>?,
    val facebook: List<String>?,
    val medium: List<String>?, // Changed type from Any? to List<String>?
    val reddit: List<String>?,
    @SerialName("source_code") val sourceCode: List<String>?,
    val website: List<String>?,
    val youtube: List<String>?
)

@Serializable
data class LinksExtendedDTO(
    val stats: StatsDTO?, // Renamed to match JSON
    val type: String,
    val url: String
)

@Serializable
data class StatsDTO(
    val contributors: Int?,
    val stars: Int?,
    val subscribers: Int?
)

@Serializable
data class WhitePaperDTO(
    val link: String,
    val thumbnail: String
)

