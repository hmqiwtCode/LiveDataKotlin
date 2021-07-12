package com.quy.livedatakotlin.trans_livedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.quy.livedatakotlin.R
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val pokemonAdapter:PokemonAdapter = PokemonAdapter {
            val intent = Intent(this,PokemonDetailActivity::class.java).apply {
                putExtra("id",it.id)
            }
            startActivity(intent)
        }

        pokemon_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pokemonAdapter
        }

        val pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)
        pokemonViewModel.getPokemons().observe(this){
            pokemonAdapter.swapData(it)
        }
    }
}