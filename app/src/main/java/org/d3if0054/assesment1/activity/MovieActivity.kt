package org.d3if0054.assesment1.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movie.*
import org.d3if0054.assesment1.R
import org.d3if0054.assesment1.adapter.MovieAdapter
import org.d3if0054.assesment1.api.Api
import org.d3if0054.assesment1.api.ApiStatus
import org.d3if0054.assesment1.api.RetrofitClient
import org.d3if0054.assesment1.databinding.ActivityMovieBinding
import org.d3if0054.assesment1.model.Movie
import org.d3if0054.assesment1.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    private var list =  ArrayList<Movie>()
    private val status = MutableLiveData<ApiStatus>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)

        setContentView (binding.root)
        showMovies()

    }

    private fun showMovies() {
        rvMovie.setHasFixedSize(true)
        rvMovie.layoutManager = LinearLayoutManager(this)

        binding.progressBar
        binding.koneksiText.isVisible=false

        RetrofitClient.instance.getMovies().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>)
            {

//                tvResponseCode.text = response.code().toString()

                val listResponse = response.body()?.moviz
                listResponse?.let { list.addAll(it) }
                val adapter = MovieAdapter(list)
                rvMovie.adapter = adapter

                binding.progressBar.isVisible = false
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

                binding.koneksiText.isVisible = true

            }

        })
    }




}