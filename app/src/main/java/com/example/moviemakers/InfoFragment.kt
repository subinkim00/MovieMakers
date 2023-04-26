package com.example.moviemakers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviemakers.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private val args: InfoFragmentArgs by navArgs()


    private val viewModel: HomeScreenViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)

        val id = args.movieId
        var adapter : MovieAdapter? = null
        val moviePosition = args.movieId

        viewModel.response.observe(viewLifecycleOwner, Observer { movie ->
            Log.i("API", "Response: " + movie.toString())
            val resultsList = movie.results
            val details = resultsList?.get(moviePosition)
            if (details != null) {
                binding.movieTitle.text = details.title
                Glide.with(binding.poster.context)
                    .load("https://image.tmdb.org/t/p/w500" + details.posterPath)
                    .into(binding.poster)
                var genres = ""
                if (details.genreIds?.isEmpty() == false) {
                    for (code in details.genreIds) {
                        if (genres == "") {
                            genres += getGenre(code.toInt())
                        } else {
                            genres += ", " + getGenre(code.toInt())
                        }
                    }
                }
                binding.genre.text = getString(R.string.Genre, genres);
                binding.maturity.text = getString(R.string.maturity,
                    if (details.adult) {
                     "Adult"
                    } else {
                        "Family"
                    });
                binding.rating.text = getString(R.string.rating, details.popularity);
                binding.releaseDate.text = getString(R.string.releaseDate, details.releaseDate);
                binding.summary.text = details.overview
                Glide.with(binding.movieBanner.context)
                    .load("https://image.tmdb.org/t/p/w500" + details.backdropPath)
                    .into(binding.movieBanner)
            }

        })

        return binding.root
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

