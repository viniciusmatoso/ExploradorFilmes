package com.app.exploradorfilmes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.exploradorfilmes.data.remote.MoviesAPI
import com.app.exploradorfilmes.data.remote.response.PopularMovieResponse
import com.app.exploradorfilmes.domain.PopularMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    val api: MoviesAPI
    ) : ViewModel() {

    private val _popularMoveis = MutableLiveData<List<PopularMovie>>()
    val popularMovie: LiveData<List<PopularMovie>> get() = _popularMoveis

    private val _popularMoviesErrorResponse = MutableLiveData<String>()
    val popularMoveisErrorResponse: LiveData<String?> get() = _popularMoviesErrorResponse

    suspend fun getPopularMoveis() = withContext(Dispatchers.Main){
        val call: Call<PopularMovieResponse> = api.getPopularMovies()
        call.enqueue(
            object  : Callback<PopularMovieResponse>{
                override fun onResponse(
                    call: Call<PopularMovieResponse>,
                    response: Response<PopularMovieResponse>
                ) {
                    if(response.isSuccessful){
                        _popularMoveis.value = response.body()?.popularMovie?.map {
                            it.toPopularMovie()
                        }
                    }
                }

                override fun onFailure(call: Call<PopularMovieResponse>, error: Throwable) {
                    _popularMoviesErrorResponse.value = error.message
                }

            }
        )
    }

}