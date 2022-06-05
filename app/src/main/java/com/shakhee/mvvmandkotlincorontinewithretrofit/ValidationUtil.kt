package com.shakhee.mvvmandkotlincorontinewithretrofit

import com.shakhee.mvvmandkotlincorontinewithretrofit.model.Model

object ValidationUtil {

    fun validateMovie(movie: Model.Movie) : Boolean {
        println("sOrder......ValidationUtil.....................movie.name............"+movie.name)
        println("sOrder......ValidationUtil.....................movie.imageUrl............"+movie.imageUrl)
        println("sOrder......ValidationUtil.....................movie.category............"+movie.category)
        println("sOrder......ValidationUtil.....................movie.desc............"+movie.desc)

        if (movie.name.isNotEmpty() && movie.category.isNotEmpty()) {


            return true
        }
        return false
    }
}
