package com.example.moviemakers

import com.squareup.moshi.Json

data class Movie(@Json(name = "dates")
                 val dates: Dates,
                 @Json(name = "page")
                 val page: Int = 0,
                 @Json(name = "totalPages")
                 val totalPages: Int = 0,
                 @Json(name = "results")
                 val results: List<ResultsItem>?,
                 @Json(name = "totalResults")
                 val totalResults: Int = 0)