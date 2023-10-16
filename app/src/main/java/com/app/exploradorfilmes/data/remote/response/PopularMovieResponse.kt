package com.app.exploradorfilmes.data.remote.response

import com.app.exploradorfilmes.data.remote.dto.PopularMovieDto
import com.google.gson.annotations.SerializedName

class PopularMovieResponse(
    @SerializedName("results")
    val popularMovie: List<PopularMovieDto>

)