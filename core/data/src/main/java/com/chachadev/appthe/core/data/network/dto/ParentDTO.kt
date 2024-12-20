package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.Serializable


@Serializable
data class ParentDTO(
    val id: String,
    val name: String,
    val symbol: String
)