package com.quy.livedatakotlin.trans_livedata

import androidx.lifecycle.MutableLiveData

object PokemonProvider {
    private val pokemons = listOf<Pokemon>(
        Pokemon(1, "Bulbasaur", "Grass"),
        Pokemon(2, "Squirtle", "Water"),
        Pokemon(3, "Caterpie", "Bug"),
        Pokemon(4, "Charmander", "Fire"),
        Pokemon(5, "Pidgey", "Flying")
    )

    fun getPokemons() = pokemons
    fun getPokemonsById(id:Long) = pokemons.first { it.id == id }
    fun getPokemonLive(id:Long) = MutableLiveData<Pokemon>().apply {
        value = pokemons.first { it.id == id }
    }
}