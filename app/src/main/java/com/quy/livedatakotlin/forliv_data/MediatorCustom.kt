package com.quy.livedatakotlin.forliv_data

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MediatorCustom : ViewModel(){
    val livedata1 = MutableLiveData<String>("Live data 1")
    val livedata2 = MutableLiveData<String>("Live data 2")

    val liveDataMediator:MediatorLiveData<String>  = MediatorLiveData()

    init {
        liveDataMediator.addSource(livedata1){
            println("MEOMEOWWWW")
            if (livedata1.value.equals("Hieu")){
                liveDataMediator.postValue("OK")
            }
        }
    }



}