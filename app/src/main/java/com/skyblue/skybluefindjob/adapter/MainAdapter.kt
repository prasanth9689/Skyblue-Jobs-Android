package com.skyblue.skybluefindjob.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skyblue.skybluefindjob.databinding.ModelJobsListHomeBinding
import com.skyblue.skybluefindjob.model.Jobs

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var movies = mutableListOf<Jobs>()

    fun setJobsList(movies: List<Jobs>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ModelJobsListHomeBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.title.text = movie.title
        holder.binding.company.text = movie.company_name
        holder.binding.location.text = movie.location
        holder.binding.ctc.text = movie.exp
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MainViewHolder(val binding: ModelJobsListHomeBinding) : RecyclerView.ViewHolder(binding.root) {

}