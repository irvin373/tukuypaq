package com.example.tukuypacandroid.data.model

import androidx.room.*

@Entity(tableName = "plant")
data class Plant(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "groupId") val groupId: Int?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "img_dir") val imgDir: String?
)
