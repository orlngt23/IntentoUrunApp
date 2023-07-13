package com.example.urunapp.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class WelcomeViewModel {
    private val _high= MutableLiveData<String>()
    val high: LiveData<String> =_high

    private val _weight= MutableLiveData<String>()
    val weight: LiveData<String> =_weight

    private val _km= MutableLiveData<String>()
    val km: LiveData<String> =_km

    private val _kcal= MutableLiveData<String>()
    val kcal: LiveData<String> =_kcal

    private val _unk= MutableLiveData<String>()
    val unk: LiveData<String> =_unk

    private val _welcomeEnable= MutableLiveData<Boolean>()
    val welcomeEnable: LiveData<Boolean> =_welcomeEnable



    fun onHighChanged(high: String) {
        _high.value = high

    }
    fun onWeightChanged(weight:String){
        _weight.value = weight

    }
    fun onKmChanged(km: String){
        _km.value=km
    }
    fun onKcalChanged(kcal:String){
        _kcal.value= kcal
    }
    fun onUnkChanged(unk:String){
        _unk.value= unk
    }
}

