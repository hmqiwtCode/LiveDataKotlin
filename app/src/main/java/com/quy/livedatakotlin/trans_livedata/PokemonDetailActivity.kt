package com.quy.livedatakotlin.trans_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.quy.livedatakotlin.R
import kotlinx.android.synthetic.main.activity_pokemon_detail.*

class PokemonDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        val id = intent.getLongExtra("id", 1)

        val pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)
        pokemonViewModel.setPokemon(id)
        pokemonViewModel.getPokemon().observe(this, Observer {
            pokemon_details.text = it.toString()
        })

    }
}