package com.example.moviemakers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviemakers.databinding.FragmentHomeScreenBinding
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class HomeScreenFragment : Fragment() {
    private lateinit var viewModel: HomeScreenViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home_screen, container, false)

        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)

        val recyclerView = root.findViewById<RecyclerView>(R.id.movie_list_rv)
        var adapter : MovieAdapter? = null
        viewModel.response.observe(viewLifecycleOwner, Observer { movie ->
            Log.i("API", "Response: " + movie.toString())
            val resultsList = movie.results
            resultsList?.let {
                adapter = MovieAdapter(it as MutableList<ResultsItem>)
                recyclerView.adapter = adapter
            }


        })
        return root
    }




}