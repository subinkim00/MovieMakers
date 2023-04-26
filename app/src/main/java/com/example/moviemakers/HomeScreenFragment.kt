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
    private val viewModel: HomeScreenViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home_screen, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.movie_list_rv)
        var adapter : MovieAdapter? = null

        // TODO: set up MovieInfo kt file, pass id of movie
//        adapter.setOnItemClickListener(object : MovieAdapter.OnItemClickListener {
//            override fun onItemClick(itemView: View?, position: Int) {
//                val bundle = bundleOf("numBoba" to 2)
//                view?.findNavController()?.navigate(R.id.)
//                    bundle)
//            }
//        })

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