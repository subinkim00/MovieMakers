package com.example.moviemakers

import com.squareup.moshi.Json

data class ResultsItem(@Json(name = "overview")
                       val overview: String = "",
                       @Json(name = "originalLanguage")
                       val originalLanguage: String = "",
                       @Json(name = "originalTitle")
                       val originalTitle: String = "",
                       @Json(name = "video")
                       val video: Boolean = false,
                       @Json(name = "title")
                       val title: String = "",
                       @Json(name = "genreIds")
                       val genreIds: List<Integer>?,
                       @Json(name = "posterPath")
                       val posterPath: String = "",
                       @Json(name = "backdropPath")
                       val backdropPath: String = "",
                       @Json(name = "releaseDate")
                       val releaseDate: String = "",
                       @Json(name = "popularity")
                       val popularity: Double = 0.0,
                       @Json(name = "voteAverage")
                       val voteAverage: Double = 0.0,
                       @Json(name = "id")
                       val id: Int = 0,
                       @Json(name = "adult")
                       val adult: Boolean = false,
                       @Json(name = "voteCount")
                       val voteCount: Int = 0)