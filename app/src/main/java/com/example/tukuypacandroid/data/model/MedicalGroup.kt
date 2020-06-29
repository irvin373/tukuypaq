package com.example.tukuypacandroid.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity
//data class MedicalGroup(
//    @PrimaryKey val id: Int,
//    @ColumnInfo(name = "name") val firstName: String?
//)

@Entity(tableName = "MedicalGroup")
class MedicalGroup(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String
)