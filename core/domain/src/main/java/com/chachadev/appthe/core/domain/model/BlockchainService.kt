package com.chachadev.appthe.core.domain.model


data class BlockchainService(
    val id: String,
    val name: String,
    val coinCounter: Int,
    val icoCounter: Int,
    val description: String,
    val type: String,
    val coins: List<String>,
    val icos: List<String>
)