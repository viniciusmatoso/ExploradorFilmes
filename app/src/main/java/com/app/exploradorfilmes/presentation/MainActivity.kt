package com.app.exploradorfilmes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.exploradorfilmes.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.call.setOnClickListener{
            callPopularMoveis()
        }

        viewModel.popularMovie.observe(this) { popularMovie ->
            popularMovie.forEach {
                Log.i("PopularMovie", it.title)
            }
        }

    }

    private fun callPopularMoveis(){
        GlobalScope.launch {
            viewModel.getPopularMoveis()
        }
    }
}