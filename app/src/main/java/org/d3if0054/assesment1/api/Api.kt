package org.d3if0054.assesment1.api

import org.d3if0054.assesment1.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("d116b44c-16e2-4686-8b5e-fa781b880503")
    fun getMovies(): Call<MovieResponse>
}