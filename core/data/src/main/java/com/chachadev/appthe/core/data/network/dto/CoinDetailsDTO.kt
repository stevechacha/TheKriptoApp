package com.chachadev.appthe.core.data.network.dto

import com.google.gson.annotations.SerializedName

data class CoinDetailsDTO(
    val id: String?,
    val name: String?,
    val symbol: String?,
    val rank: Int?,
    @SerializedName("is_new")
    val isNew: Boolean?,
    @SerializedName("is_active")
    val isActive: Boolean?,
    val type: String?,
    @SerializedName("tags")
    val tagDTO: List<TagDTO>?,
    val team: List<TeamDTO>?,
    val description: String?,
    val message: String?,
    @SerializedName("open_source")
    val openSource: Boolean?,
    @SerializedName("started_at")
    val startedAt: String?,
    @SerializedName("development_status")
    val developmentStatus: String?,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean?,
    @SerializedName("proof_type")
    val proofType: String?,
    @SerializedName("org_structure")
    val orgStructure: String?,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String?,
    val links: CoinDetailsLinksDTO?,
    @SerializedName("links_extended")
    val linksExtendedDto: List<LinksExtendedDTO>?,
    val whitePaperDTO: WhitePaperDTO?,
    @SerializedName("first_data_at")
    val firstDataAt: String?,
    @SerializedName("last_data_at")
    val lastDataAt: String?
)

data class TagDTO(
    @SerializedName("coin_counter")
    val coinCounter: Int,
    @SerializedName("ico_counter")
    val icoCounter: Int,
    val id: String,
    val name: String
)

data class TeamDTO(
    val id: String,
    val name: String,
    val position: String
)

data class CoinDetailsLinksDTO(
    val explorer: List<String>?,
    val facebook: List<String>?,
    val medium: Any?,
    val reddit: List<String>?,
    @SerializedName("source_code")
    val sourceCode: List<String>?,
    val website: List<String>?,
    val youtube: List<String>?
)

data class WhitePaperDTO(
    val link: String,
    val thumbnail: String
)

data class StatsDTO(
    val contributors: Int?,
    val stars: Int?,
    val subscribers: Int?
)

data class ContractDTO(
    val contract: String,
    val platform: String,
    val type: String
)

data class LinksExtendedDTO(
    val statsDTO: StatsDTO?,
    val type: String,
    val url: String
)
