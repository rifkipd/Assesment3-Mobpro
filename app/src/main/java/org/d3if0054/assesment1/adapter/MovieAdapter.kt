package org.d3if0054.assesment1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import org.d3if0054.assesment1.R
import org.d3if0054.assesment1.model.Movie


class MovieAdapter(
    private val list: ArrayList<Movie>
):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie){
            with(itemView){
//                val text = "id: ${movie.id}\n" +
//                            "name: ${movie.name}"+
//                            "image: ${movie.image}"

                val text = "name : ${movie.name}\n"
                val image = "${movie.image}"

                tvResponse.text = text
                Glide.with(context)
                    .load(image)
                    .into(ivResponse)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}