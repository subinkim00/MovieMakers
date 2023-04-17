package com.example.moviemakers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeScreenViewModel : ViewModel() {
    private val _response = MutableLiveData<MutableList<ResultsItem>>()
    val response : LiveData<MutableList<ResultsItem>>
        get() = _response

    private fun getMovies() {

    }
}