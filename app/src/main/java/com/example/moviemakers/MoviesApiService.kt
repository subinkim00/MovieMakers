package com.example.moviemakers

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SectionApiService {
    @GET("now_playing?api_key=ae5f8d9a34efd2f2f0ee2033504b17d2")
    fun getSections():
            Call<MutableList<Movie>>
}

object SectionApi {
    val retrofitService : SectionApiService by lazy {
        retrofit.create(SectionApiService::class.java)
    }
}