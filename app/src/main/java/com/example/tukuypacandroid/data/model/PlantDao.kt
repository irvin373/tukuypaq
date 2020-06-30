package com.example.tukuypacandroid.data.model

import androidx.room.*

@Dao
interface PlantDao {
    @Query("SELECT * FROM plant")
    fun getAll(): List<Plant>

    @Transaction
    @Query("SELECT * FROM plant")
    fun getPlantsWithGroup(): List<PlantWithGroup>

    @Transaction
    @Query("SELECT * FROM plant Where id in (:id) LIMIT 1")
    fun getSinglePlants(id: Int): PlantWithGroup

    @Query("DELETE FROM plant")
    fun deleteAll()

    @Query("SELECT * FROM plant WHERE id IN (:id)")
    fun loadAllByIds(id: Int): List<Plant>

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): MedicalGroup

    @Insert
    fun insert(plants: List<Plant>)

    @Delete
    fun delete(plant: Plant)
}