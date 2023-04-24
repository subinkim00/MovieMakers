package com.example.moviemakers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter (private val movies: MutableList<ResultsItem>):
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitleText: TextView = itemView.findViewById(R.id.rv_movie_title_text)
        val movieGenreText: TextView = itemView.findViewById(R.id.rv_movie_genre_text)
        val moviePosterImage: ImageView = itemView.findViewById(R.id.rv_movie_poster_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.movie_list_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        val movieTitle = holder.movieTitleText
        val genre = holder.movieGenreText
        val poster = holder.moviePosterImage

        movieTitle.text = movie.originalTitle
        var genres = ""
        if (movie.genreIds?.isEmpty() == false) {
            for(code in movie.genreIds) {
                if (genres == "") {
                    genres += getGenre(code.toInt())
                } else {
                   genres += ", " + getGenre(code.toInt())
                }
            }
        }

        genre.text = genres

        Glide.with(poster.context)
            .load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .into(poster)

    }

    private fun getGenre(genreID : Int) : String {
        var genre = ""
        genre = when(genreID) {
            28 -> "Action"
            12 -> "Adventure"
            16 -> "Animation"
            35 -> "Comedy"
            80 -> "Crime"
            99 -> "Documentary"
            18 -> "Drama"
            10751 -> "Family"
            14 -> "Fantasy"
            36 -> "History"
            27 -> "Horror"
            10402 -> "Music"
            9648 -> "Mystery"
            10749 -> "Romance"
            878 -> "Science Fiction"
            10770 -> "TV Movie"
            53 -> "Thriller"
            10752 -> "War"
            37 -> "Western"
            else -> ""
        }
        return genre

    }

    }