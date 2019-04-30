package com.Bryan.laboratorio4.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.Bryan.laboratorio4.R
import com.Bryan.laboratorio4.pojos.Movie
import kotlinx.android.synthetic.main.main_content_fragment_layout.view.*

class MainContentFragment: Fragment() {

    var movie = Movie()

    companion object {
        fun newInstance(movie: Movie): MainContentFragment{
            val newFragment = MainContentFragment()
            newFragment.movie = movie
            return newFragment
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.main_content_fragment_layout, container, false)

        bindData(view)

        return view
    }

    fun bindData(view: View){
        view.movie_title_main_content_fragment.text = movie.Name
        view.name_main_content_fragment.text = movie.Name
        view.type1_main_content_fragment.text = movie.Type1
        view.type2_main_content_fragment.text = movie.Type2
        view.weight_main_content_fragment.text = movie.weight
        Glide.with(view).load(movie.sprite)
            .placeholder(R.drawable.ic_launcher_background)
            .into(view.image_main_content_fragment)
    }

}