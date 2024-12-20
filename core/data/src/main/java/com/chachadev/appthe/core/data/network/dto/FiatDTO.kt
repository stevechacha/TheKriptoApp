package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.Serializable


@Serializable
data class FiatDTO(
    val name: String,
    val symbol: String
)