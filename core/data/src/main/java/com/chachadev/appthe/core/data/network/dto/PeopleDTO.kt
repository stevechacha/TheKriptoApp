package com.chachadev.appthe.core.data.network.dto

import com.google.gson.annotations.SerializedName

data class PeopleDTO(
    val description: String,
    val id: String,
    val links: PeopleDTOLinks,
    val name: String,
    val positionDTOS: List<PositionDTO>,
    @SerializedName("teams_count")
    val teamsCount: Int
)

data class PositionDTO(
    @SerializedName("coin_id")
    val coinId: String,
    @SerializedName("coin_name")
    val coinName: String,
    val position: String
)

data class PeopleDTOLinks(
    val additionalDTO: List<AdditionalDTO>,
    val githubDTO: List<GithubDTO>,
    val linkedinDTO: List<LinkedinDTO>,
    val mediumDTO: List<MediumDTO>,
    val twitterDTO: List<TwitterDTO>
)

data class AdditionalDTO(
    val followers: Int,
    val url: String
)

data class LinkedinDTO(
    val followers: Int,
    val url: String
)

data class MediumDTO(
    val followers: Int,
    val url: String
)
data class TwitterDTO(
    val followers: Int,
    val url: String
)

data class GithubDTO(
    val followers: Int,
    val url: String
)

data class ParentDTO(
    val id: String?,
    val name: String?,
    val symbol: String?
)
