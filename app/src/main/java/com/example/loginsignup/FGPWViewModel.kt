package com.example.loginsignup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FGPWViewModel : ViewModel() {
    val email: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}