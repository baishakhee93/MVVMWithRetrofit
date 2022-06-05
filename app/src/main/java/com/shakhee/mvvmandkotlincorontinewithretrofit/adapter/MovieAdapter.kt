package com.shakhee.mvvmandkotlincorontinewithretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shakhee.mvvmandkotlincorontinewithretrofit.databinding.AdapterMovieBinding
import com.shakhee.mvvmandkotlincorontinewithretrofit.model.Model

class MovieAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var movieList = mutableListOf<Model.Movie>()

    fun setMovies(movies: List<Model.Movie>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val movie = movieList[position]
        println("sOrder.............MovieAdapter....................movie..........."+movie)
        if (ValidationUtil.validateMovie(movie)) {
            holder.binding.name.text = movie.name
            holder.binding.desc.text = movie.desc
            Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {

}