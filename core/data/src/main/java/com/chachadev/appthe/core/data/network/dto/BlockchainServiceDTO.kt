package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BlockchainServiceDTO(
    val id: String,
    val name: String,
    @SerialName("coin_counter") val coinCounter: Int,
    @SerialName("ico_counter") val icoCounter: Int,
    val description: String,
    val type: String,
    val coins: List<String>,
    val icos: List<String>
)
