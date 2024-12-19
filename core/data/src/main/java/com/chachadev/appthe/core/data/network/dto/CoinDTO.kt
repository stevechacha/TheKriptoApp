package com.chachadev.appthe.core.data.network.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class CoinDTO(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)