//package com.example.tukuypacandroid.data.model
//
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import android.content.Context
//
//@Database(entities = arrayOf(Recipe::class), version = 1, exportSchema = false)
//abstract class RoomSingleton : RoomDatabase(){
//    abstract fun recipeDao():RecipeDao
//
//    companion object{
//        private var INSTANCE: RoomSingleton? = null
//        fun getInstance(context: Context): RoomSingleton{
//            if (INSTANCE == null){
//                INSTANCE = Room.databaseBuilder(
//                        context,
//                        RoomSingleton::class.java,
//                        "plantsDB")
//                        .build()
//            }
//            return INSTANCE as RoomSingleton
//        }
//    }
//}