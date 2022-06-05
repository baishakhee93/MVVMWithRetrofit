package com.shakhee.mvvmandkotlincorontinewithretrofit.repository

import com.shakhee.mvvmandkotlincorontinewithretrofit.service.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllMovies() = retrofitService.getAllMovies()

}
