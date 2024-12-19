package com.chachadev.appthe.core.domain.model


data class People(
    val description: String,
    val id: String,
    val peopleLinks: PeopleLinks,
    val name: String,
    val positions: List<Position>,
    val teamsCount: Int
)

data class Position(
    val coinId: String,
    val coinName: String,
    val position: String
)

data class PeopleLinks(
    val additional: List<Additional>,
    val github: List<Github>,
    val linkedin: List<Linkedin>,
    val medium: List<Medium>,
    val twitter: List<Twitter>
)

data class Additional(
    val followers: Int,
    val url: String
)

data class Linkedin(
    val followers: Int,
    val url: String
)

data class Medium(
    val followers: Int,
    val url: String
)
data class Twitter(
    val followers: Int,
    val url: String
)

data class Github(
    val followers: Int,
    val url: String
)

data class PeopleParent(
    val id: String?,
    val name: String?,
    val symbol: String?
)
