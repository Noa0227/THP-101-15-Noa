package com.example.loginsignup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RPWViewModel : ViewModel() {
    val password: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val cfpassword: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}