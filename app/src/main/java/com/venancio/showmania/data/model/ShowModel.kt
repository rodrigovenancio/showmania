package com.venancio.showmania.data.model

data class ShowModel(
    val id: Long,
    val name: String,
    val type: String,
    val image: Image,
    val schedule: Schedule,
    val language: String,
    val genres: ArrayList<String>,
    val summary: String
)

data class Image(
    val medium: String,
    val original: String
)

data class Schedule(
    val time: String,
    val days: ArrayList<String>
)