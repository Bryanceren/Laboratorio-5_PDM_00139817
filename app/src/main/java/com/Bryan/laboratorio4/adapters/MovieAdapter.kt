package com.Bryan.laboratorio4.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.Bryan.laboratorio4.MyMovieAdapter
import com.Bryan.laboratorio4.R
import com.Bryan.laboratorio4.pojos.Movie
import kotlinx.android.synthetic.main.cardview_movie.view.*

class MovieAdapter(var movies: List<Movie>, val clickListener: (Movie) -> Unit): RecyclerView.Adapter<MovieAdapter.ViewHolder>(), MyMovieAdapter {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_movie, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position], clickListener)

    override fun changeDataSet(newDataSet: List<Movie>) {
        this.movies = newDataSet
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Movie, clickListener: (Movie) -> Unit) = with(itemView){
            Glide.with(itemView.context)
                .load(item.sprite)
                .placeholder(R.drawable.ic_launcher_background)
                .into(poke_image_cv)

            poke_title_cv.text = item.Name
            poke_type1_cv.text = item.Type1
            poke_type2_cv.text = item.Type2
            this.setOnClickListener { clickListener(item) }
        }
    }
}