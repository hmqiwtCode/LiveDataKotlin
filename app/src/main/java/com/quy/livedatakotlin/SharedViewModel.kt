package com.quy.livedatakotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val data: MutableLiveData<String> = MutableLiveData()

    fun data(): MutableLiveData<String> = data

    fun updateData(message: String){
        data.value = message
    }

    init {
        data.value = "This is default message"
    }

}