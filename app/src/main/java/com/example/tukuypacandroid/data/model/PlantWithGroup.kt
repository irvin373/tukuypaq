package com.example.tukuypacandroid.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class PlantWithGroup(
    @Embedded val plant: Plant,
    @Relation(
        parentColumn = "groupId",
        entityColumn = "id"
    )
    val group: MedicalGroup
)
