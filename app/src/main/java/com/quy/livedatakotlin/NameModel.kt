package com.quy.livedatakotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameModel: ViewModel() {
    val currentName : MutableLiveData<String> by lazy {
        MutableLiveData<String>()

    }

}