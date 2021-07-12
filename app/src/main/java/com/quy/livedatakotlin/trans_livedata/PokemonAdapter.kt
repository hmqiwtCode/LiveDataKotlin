package com.quy.livedatakotlin.trans_livedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quy.livedatakotlin.R
import kotlinx.android.synthetic.main.row_pokemon.view.*


class PokemonAdapter(private val listener: (Pokemon) -> Unit) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    private var data: List<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(listener,LayoutInflater.from(parent.context).inflate(R.layout.row_pokemon,parent,false))
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    fun swapData(data: List<Pokemon>) {
        this.data = data
      //  notifyDataSetChanged()
    }

    class PokemonViewHolder(private val listener: (Pokemon) -> Unit, itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: Pokemon) = with(itemView){
            pokemon_name.text = item.name
            setOnClickListener { listener(item) }
        }
    }

}