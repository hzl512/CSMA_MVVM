package com.mason.csma.buying.frags

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BuyingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "求购"
    }
    val text: LiveData<String> = _text
}