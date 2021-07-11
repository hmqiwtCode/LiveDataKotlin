package com.quy.livedatakotlin.combinev

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    private var _firstPlayerScore = MutableLiveData<Int>()
    val firstPlayerScore: LiveData<Int>
        get()  = _firstPlayerScore

    private var _secondPlayerScore = MutableLiveData<Int>()
    val secondPlayerScore: LiveData<Int>
        get()  = _secondPlayerScore


    val currentScore1: LiveData<Pair<Int,Int>> = combine(_firstPlayerScore,_secondPlayerScore)


    fun <A, B> combine(a: LiveData<A>, b: LiveData<B>): LiveData<Pair<A, B>> {
        return MediatorLiveData<Pair<A, B>>().apply {
            fun combine() {
                val aValue = a.value
                val bValue = b.value
                if (aValue != null && bValue != null && aValue != "" && bValue != "") {
                    postValue(Pair(aValue, bValue))
                }
            }

            addSource(a) { combine() }
            addSource(b) { combine() }

            combine()
        }
    }



    fun setFirstPlayerScore(score: Int){
        _firstPlayerScore.value = score
    }

    fun setSecondPlayerScore(score: Int){
        _secondPlayerScore.value = score
    }
}