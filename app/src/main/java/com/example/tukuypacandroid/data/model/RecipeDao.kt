package com.example.tukuypacandroid.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun getAll(): List<Recipe>

    @Query("SELECT * FROM recipe WHERE id IN (:id)")
    fun loadAllByIds(id: Int): Recipe

    @Query("DELETE FROM recipe")
    fun deleteAll()

    @Insert
    fun insert(recipe: List<Recipe>)

    @Delete
    fun delete(recipe: Recipe)
}