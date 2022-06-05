package com.shakhee.mvvmandkotlincorontinewithretrofit.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shakhee.mvvmandkotlincorontinewithretrofit.repository.MainRepository
import com.shakhee.mvvmandkotlincorontinewithretrofit.viewmodel.MainViewModel

class MyViewModelFactory (private val mainRepository: MainRepository) : ViewModelProvider.Factory {

       override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            println("sOrder......MyViewModelFactory........mainRepository......"+mainRepository)
            return MainViewModel(mainRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}