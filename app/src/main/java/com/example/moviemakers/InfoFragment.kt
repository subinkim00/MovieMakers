package com.example.moviemakers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moviemakers.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    val args : InfoFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.movieTitle.text = args.MovieInfo.originalTitle

        Glide.with(binding.poster.context)
            .load("https://image.tmdb.org/t/p/w500" + args.MovieInfo.posterPath)
            .into(binding.poster)

        //genre set up
        var genres = ""
        if (args.MovieInfo.genreIds?.isEmpty() == false) {
            for (code in args.MovieInfo.genreIds!!) {
                if (genres == "") {
                    genres += getGenre(code.toInt())
                } else {
                    genres += ", " + getGenre(code.toInt())
                }
            }
        }
        binding.genre.text = genres

        if (args.MovieInfo.adult) {
            binding.maturity.text = "No"
        } else {
            binding.maturity.text = "Yes"
        }


        binding.rating.text = args.MovieInfo.voteAverage.toString()

        binding.releaseDate.text = args.MovieInfo.releaseDate

        binding.summary.text = args.MovieInfo.overview


        Glide.with(binding.backdrop.context)
            .load("https://image.tmdb.org/t/p/w500" + args.MovieInfo.backdropPath)
            .into(binding.backdrop)

        return root
    }

    private fun getGenre(genreID: Int): String {
        var genre = ""
        genre = when (genreID) {
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