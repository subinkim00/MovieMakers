package com.example.moviemakers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class InfoFragment : Fragment() {
    private lateinit var viewModel: InfoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_info, container, false)
        viewModel = ViewModelProvider(this).get(InfoViewModel::class.java)


        return root
    }

}