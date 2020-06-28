package com.example.tukuypacandroid

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
//import com.example.tukuypacandroid.data.AppDatabase
import com.example.tukuypacandroid.data.RoomSingleton
import com.example.tukuypacandroid.data.model.MedicalGroup
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard))
//        val db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "plantsDB"
//        ).build()
        val db = RoomSingleton.getInstance(applicationContext);
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        val list = db.medicalGroupDao().getAll();
//        println(list)
//        db.medicalGroupDao().insertAll(MedicalGroup(1, "digestion"))
    }
}