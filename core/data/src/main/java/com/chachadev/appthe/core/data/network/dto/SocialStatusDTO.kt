package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SocialStatusDTO(
    val date: String,
    @SerialName("user_name") val userName: String,
    @SerialName("user_image_link") val userImageLink: String,
    val status: String,
    @SerialName("is_retweet") val isRetweet: Boolean,
    @SerialName("retweet_count") val retweetCount: Int,
    @SerialName("like_count") val likeCount: Int,
    @SerialName("status_link") val statusLink: String,
    @SerialName("status_id") val statusId: String,
    @SerialName("media_link") val mediaLink: String,
    @SerialName("youtube_link") val youtubeLink: String
)




