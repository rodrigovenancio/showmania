package com.venancio.showmania.data.model

data class EpisodeModel(
    val id: Long,
    val name: String,
    val season: Int,
    val number: Int,
    val rating: Rating,
    val image: Image,
)

data class Rating(
    val average: Double
)
