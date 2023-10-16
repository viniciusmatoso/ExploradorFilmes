package com.app.exploradorfilmes.domain

data class PopularMovie(
    val id: Long,
    val title: String,
    val description: String,
    val voteAverage: Double
)
