package com.app.exploradorfilmes.data.remote

import com.app.exploradorfilmes.data.remote.response.PopularMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {

    @GET("/3/movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<PopularMovieResponse>

    companion object {
        val BASE_URL = "https://api.themoviedb.org/"
        val API_KEY = "d7ef35db6a8db386548bb06fff0f9aeb"
    }
}