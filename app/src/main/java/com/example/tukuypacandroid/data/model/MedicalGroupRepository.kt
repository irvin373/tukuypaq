package com.example.tukuypacandroid.data.model

import androidx.lifecycle.LiveData

class MedicalGroupRepository(private val medicalGroupDao: MedicalGroupDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allGroups: LiveData<List<MedicalGroup>> = medicalGroupDao.getAll()

    suspend fun insert(group: MedicalGroup) {
        medicalGroupDao.insert(group)
    }
}