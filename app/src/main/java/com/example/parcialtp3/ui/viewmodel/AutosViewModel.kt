package com.example.parcialtp3.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3.apiServiceBuilder.ApiServiceBuilder
import com.example.parcialtp3.domain.Car
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AutosViewModel @Inject constructor(
    private val ninjaAPIService : ApiServiceBuilder
): ViewModel(){

    var carList = MutableLiveData<List<Car>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = ninjaAPIService.getCars()

            if (!result.isNullOrEmpty()) {
                carList.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}