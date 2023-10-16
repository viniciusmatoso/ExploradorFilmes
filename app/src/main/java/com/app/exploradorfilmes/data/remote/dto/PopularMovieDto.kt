package com.app.exploradorfilmes.data.remote.dto

import com.app.exploradorfilmes.domain.PopularMovie
import com.google.gson.annotations.SerializedName

class PopularMovieDto(
    val id: Long,
    val title: String,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
){
    fun toPopularMovie() : PopularMovie {
        return PopularMovie(
            id = id,
            title = title,
            description = overview,
            voteAverage = voteAverage
        )
    }
}