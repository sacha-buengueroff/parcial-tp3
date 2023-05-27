package com.example.parcialtp3.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3.handlers.CarServiceHandler
import com.example.parcialtp3.model.domain.Car
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AutosViewModel(): ViewModel() {

    private var carList = MutableLiveData<List<Car>>()
    private val isLoading = MutableLiveData<Boolean>()

    fun createCarList(handler: CarServiceHandler) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = handler()

            if (!result.isNullOrEmpty()) {
                carList.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun getCarList(): MutableLiveData<List<Car>> {return this.carList}
}