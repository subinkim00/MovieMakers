package com.example.moviemakers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private val _response = MutableLiveData<Movie>()
    val response : LiveData<Movie>
        get() = _response

    init {
        //_response.value = mutableListOf()
        getSections()
    }

    private fun getSections() {
        MovieApi.retrofitService.getMovies().enqueue(object: Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                _response.value = response.body()
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.i("API", "ERROR: " + t.message)
            }

        })
    }
}