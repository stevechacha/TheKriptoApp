package com.chachadev.appthe.core.domain.model

data class SocialStatus(
    val date: String,
    val userName: String,
    val userImageLink: String,
    val status: String,
    val isRetweet: Boolean,
    val retweetCount: Int,
    val likeCount: Int,
    val statusLink: String,
    val statusId: String,
    val mediaLink: String,
    val youtubeLink: String
)
