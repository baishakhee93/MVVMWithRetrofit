package com.shakhee.mvvmandkotlincorontinewithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shakhee.mvvmandkotlincorontinewithretrofit.databinding.ActivityMainBinding
import com.shakhee.mvvmandkotlincorontinewithretrofit.viewmodel.MainViewModel
import com.shakhee.mvvmandkotlincorontinewithretrofit.model.MyViewModelFactory
import com.shakhee.mvvmandkotlincorontinewithretrofit.repository.MainRepository
import com.shakhee.mvvmandkotlincorontinewithretrofit.service.RetrofitService


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private val adapter = MovieAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService = RetrofitService.getInstance()
       val mainRepository = MainRepository(retrofitService)
        val factory = MyViewModelFactory(mainRepository)

       viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this) {
            adapter.setMovies(it)
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        viewModel.getAllMovies()

    }



}