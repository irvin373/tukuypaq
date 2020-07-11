package com.example.tukuypacandroid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tukuypacandroid.data.model.PlantWithGroup

class HomeViewModel : ViewModel() {
    private val _plants = MutableLiveData<List<PlantWithGroup>>().apply {
        value = emptyList()
    }
    val plants: LiveData<List<PlantWithGroup>> = _plants
}