package com.mason.cmsa.ui.mine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MineViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "我的"
    }
    val text: LiveData<String> = _text
}