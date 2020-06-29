package com.example.tukuypacandroid.data.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MedicalGroupDao {
    @Query("SELECT * from MedicalGroup")
    fun getAll():  LiveData<List<MedicalGroup>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(medical: MedicalGroup)

    @Query("DELETE FROM MedicalGroup")
    suspend fun deleteAll()

    @Delete
    fun delete(MedicalGroup: MedicalGroup)
}
