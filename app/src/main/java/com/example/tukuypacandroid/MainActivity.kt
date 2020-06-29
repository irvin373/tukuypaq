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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard))
        val db = RoomSingleton.getInstance(applicationContext);
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        GlobalScope.launch {
//            db.medicalGroupDao().insert(MedicalGroup(2, "digestion"))
            val data = db.medicalGroupDao().getAll()

            data?.forEach {
                println("===============")
                println(it.name)
            }
        }
//        val list = db.medicalGroupDao().getAll();
//        println(list)
//        db.medicalGroupDao().insert(MedicalGroup(2, "digestion"))
    }
}