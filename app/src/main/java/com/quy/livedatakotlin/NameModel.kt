package com.quy.livedatakotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameModel: ViewModel() {
    val currentName : MutableLiveData<String> by lazy {
        MutableLiveData<String>()

    }
    fun setCurrentName(){
        currentName.value = "OK nhu vay di"
    }


    fun setPar(){
        currentName.value = "Change thu cho vui"
    }


}