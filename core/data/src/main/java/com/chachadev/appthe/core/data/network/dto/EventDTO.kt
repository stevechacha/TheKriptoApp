package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class EventDTO(
    val id: String,
    val date: String,
    @SerialName("date_to") val dateTo: String,
    val name: String,
    val description: String,
    @SerialName("is_conference") val isConference: Boolean,
    val link: String,
    @SerialName("proof_image_link") val proofImageLink: String
)


