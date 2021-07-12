package com.quy.livedatakotlin.trans_livedata

import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class PokemonViewModel:ViewModel() {
    private var pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
    private var pokemonId: MutableLiveData<Long> = MutableLiveData()
    private var pokemon: LiveData<Pokemon>

    init {
        pokemons.value = PokemonProvider.getPokemons()
        pokemon = Transformations.map(pokemonId){
            PokemonProvider.getPokemonsById(it)
        }

    }

    fun getPokemons() = pokemons

    fun setPokemon(id: Long) {
        pokemonId.value = id
    }

    fun getPokemon() = pokemon

}