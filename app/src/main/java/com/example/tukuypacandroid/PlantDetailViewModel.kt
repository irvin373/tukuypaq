package com.example.tukuypacandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tukuypacandroid.data.model.PlantWithGroup

class PlantDetailViewModel : ViewModel() {
    private val _plant = MutableLiveData<PlantWithGroup>().apply {
        value = null
    }

    fun setPlant(plant: PlantWithGroup?) {
        _plant.postValue(plant)
    }
    val plant: LiveData<PlantWithGroup> = _plant
}