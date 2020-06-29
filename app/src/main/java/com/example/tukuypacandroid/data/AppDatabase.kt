package com.example.tukuypacandroid.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tukuypacandroid.data.model.MedicalGroup
import com.example.tukuypacandroid.data.model.MedicalGroupDao

//@Database(entities = arrayOf(MedicalGroup::class), version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun medicalGroupDao(): MedicalGroupDao
//}

@Database(entities = [MedicalGroup::class], version = 1, exportSchema = false)
abstract class RoomSingleton : RoomDatabase(){
    abstract fun medicalGroupDao():MedicalGroupDao

    companion object{
        private var INSTANCE: RoomSingleton? = null
        fun getInstance(context: Context): RoomSingleton{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    RoomSingleton::class.java,
                    "tuquypac.db")
                    .build()
            }
            return INSTANCE as RoomSingleton
        }
    }
}
