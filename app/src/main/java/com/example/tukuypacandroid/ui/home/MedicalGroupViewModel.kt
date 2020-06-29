package com.example.tukuypacandroid.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tukuypacandroid.data.model.MedicalGroup
import com.example.tukuypacandroid.data.model.MedicalGroupRepository
import com.example.tukuypacandroid.data.model.MedicalGroupRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicalGroupViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MedicalGroupRepository
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allgroups: LiveData<List<MedicalGroup>>

    init {
        val medicalDao = MedicalGroupRoomDatabase.getDatabase(application, viewModelScope).medicalGroupDao()
        repository = MedicalGroupRepository(medicalDao)
        allgroups = repository.allGroups
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(group: MedicalGroup) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(group)
    }
}