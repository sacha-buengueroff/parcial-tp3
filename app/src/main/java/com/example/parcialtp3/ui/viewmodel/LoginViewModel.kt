package com.example.parcialtp3.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    var userName = MutableLiveData<String>()

    fun saveUserName(userName : String) {
        this.userName.postValue(userName)
    }
}