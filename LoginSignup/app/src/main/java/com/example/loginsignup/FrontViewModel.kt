package com.example.loginsignup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FrontViewModel : ViewModel() {
    val user: MutableLiveData<User> by lazy { MutableLiveData<User>() }
}