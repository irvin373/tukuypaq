package com.example.tukuypacandroid.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MedicalGroupDao {
    @Query("SELECT * FROM medicalGroup")
    fun getAll(): List<MedicalGroup>

    @Query("SELECT * FROM medicalGroup WHERE id IN (:id)")
    fun loadAllByIds(id: Int): MedicalGroup

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): MedicalGroup

    @Insert
    fun insert(medicalGroup: MedicalGroup)

    @Delete
    fun delete(MedicalGroup: MedicalGroup)
}