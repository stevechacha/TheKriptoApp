package com.chachadev.appthe.core.domain.model

data class Event(
    val id: String,
    val date: String,
    val dateTo: String,
    val name: String,
    val description: String,
    val isConference: Boolean,
    val link: String,
    val proofImageLink: String
)