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
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class HomeScreenFragment : Fragment() {
    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var resultsList : List<ResultsItem>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home_screen, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.movie_list_rv)
        var adapter : MovieAdapter? = null

        viewModel.response.observe(viewLifecycleOwner, Observer { movie ->
            Log.i("API", "Response: " + movie.toString())
            resultsList = movie.results!! // initialize the resultsList property
            adapter = MovieAdapter(resultsList as MutableList<ResultsItem>)
            recyclerView.adapter = adapter

            adapter!!.setOnItemClickListener(object : MovieAdapter.OnItemClickListener {
                override fun onItemClick(itemView: View?, position: Int) {
                    val movieInfo = resultsList[position]
                    val action = HomeScreenFragmentDirections.actionHomeScreenFragmentToInfoFragment(movieInfo)
                    view?.findNavController()?.navigate(action)
                }
            })
        })



        return root
    }




}