package com.example.tukuypacandroid.data.model

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [MedicalGroup::class], version = 1, exportSchema = false)
public abstract class MedicalGroupRoomDatabase : RoomDatabase() {
    abstract fun medicalGroupDao(): MedicalGroupDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MedicalGroupRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): MedicalGroupRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MedicalGroupRoomDatabase::class.java,
                    "tuquypac"
                ).addCallback(MedicalGroupDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class MedicalGroupDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.medicalGroupDao())
                }
            }
        }

        suspend fun populateDatabase(wordDao: MedicalGroupDao) {
            // Delete all content here.
//            wordDao.deleteAll()

            // Add sample words.
            var word = MedicalGroup(1, "Digestivo")
            wordDao.insert(word)

            // TODO: Add your own words!
        }
    }

}
//@Database(entities = arrayOf(MedicalGroup::class), version = 1, exportSchema = false)
//abstract class RoomSingleton : RoomDatabase(){
//    abstract fun medicalGroupDao():MedicalGroupDao
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