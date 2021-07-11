package com.quy.livedatakotlin.mediatore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    private var _firstPlayerScore = MutableLiveData<Float>(0f)
    val firstPlayerScore: LiveData<Float>
        get()  = _firstPlayerScore

    private var _secondPlayerScore = MutableLiveData<Float>(0f)
    val secondPlayerScore: LiveData<Float>
        get()  = _secondPlayerScore

    //region
    val currentScore = MediatorLiveData<Float>()

    val currentScore1: LiveData<Pair<Float,Float>> = combine(_firstPlayerScore,_secondPlayerScore)

    init{
        currentScore.addSource(_firstPlayerScore) { value ->
            if (_secondPlayerScore.value == 10f){
                currentScore.setValue(value)
            }

        }
        currentScore.addSource(_secondPlayerScore) { value ->
            if (_firstPlayerScore.value == 10f){
                currentScore.setValue(value)
            }

        }
    }
    //endregion

    fun setFirstPlayerScore(score: Float){
        _firstPlayerScore.value = score
    }

    fun setSecondPlayerScore(score: Float){
        _secondPlayerScore.value = score
    }


    fun <A, B> combine(a: LiveData<A>, b: LiveData<B>): LiveData<Pair<A, B>> {
        return MediatorLiveData<Pair<A, B>>().apply {
            fun combine() {
                val aValue = a.value
                val bValue = b.value
                if (aValue != null && bValue != null) {
                    postValue(Pair(aValue, bValue))
                }
            }

            addSource(a) { combine() }
            addSource(b) { combine() }

            combine()
        }
    }
}