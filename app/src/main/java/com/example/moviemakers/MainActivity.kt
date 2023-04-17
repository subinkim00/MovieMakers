package com.example.moviemakers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: SectionViewModel by viewModels()
//        TODO: PUT IN RECYCLER VIEW STUFFS HERE
    }
}