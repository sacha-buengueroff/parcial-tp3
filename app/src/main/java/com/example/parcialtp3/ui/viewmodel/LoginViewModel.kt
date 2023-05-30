package com.example.parcialtp3.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var userName = MutableLiveData<String>()
    var pass = MutableLiveData<String>()

    fun saveUserName(userName: String) {
        if (userName.isNotBlank()) {
            this.userName.postValue(userName)
        } else {
            throw IllegalArgumentException("El usuario no puede estar vacio")
        }
    }

    fun savePass(pass: String) {
        if (pass.isNotBlank()) {
            this.pass.postValue(pass)
        } else {
            throw IllegalArgumentException("La contraseña no puede estar vacia")
        }
    }
}