package com.Bryan.laboratorio4

import com.Bryan.laboratorio4.pojos.Movie

object AppConstants{
    val dataset_saveinstance_key = "CLE"
    val MAIN_LIST_KEY = "key_list_movies"
}

interface MyMovieAdapter {
    fun changeDataSet(newDataSet : List<Movie>)
}