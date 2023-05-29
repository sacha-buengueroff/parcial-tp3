package com.example.parcialtp3.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parcialtp3.domain.Car

class AutosViewModel(): ViewModel() {

    private var carList = MutableLiveData<List<Car>>()
    private val isLoading = MutableLiveData<Boolean>()

    /*fun createCarList(handler: CarServiceHandler) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = handler()

            if (!result.isNullOrEmpty()) {
                carList.postValue(result)
                isLoading.postValue(false)
            }
        }
    }*/

    fun getCarList(): MutableLiveData<List<Car>> {return this.carList}
}