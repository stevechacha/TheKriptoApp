package com.chachadev.appthe.core.data.network.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class PeopleDTO(
    val description: String,
    val id: String,
    val links: PeopleDTOLinks,
    val name: String,
    val positionDTOS: List<PositionDTO>,
    @SerializedName("teams_count")
    val teamsCount: Int
)

@Serializable
data class PositionDTO(
    @SerializedName("coin_id")
    val coinId: String,
    @SerializedName("coin_name")
    val coinName: String,
    val position: String
)

@Serializable
data class PeopleDTOLinks(
    val additionalDTO: List<AdditionalDTO>,
    val githubDTO: List<GithubDTO>,
    val linkedinDTO: List<LinkedinDTO>,
    val mediumDTO: List<MediumDTO>,
    val twitterDTO: List<TwitterDTO>
)

@Serializable
data class AdditionalDTO(
    val followers: Int,
    val url: String
)

@Serializable
data class LinkedinDTO(
    val followers: Int,
    val url: String
)

@Serializable
data class MediumDTO(
    val followers: Int,
    val url: String
)

@Serializable
data class TwitterDTO(
    val followers: Int,
    val url: String
)

@Serializable
data class GithubDTO(
    val followers: Int,
    val url: String
)

