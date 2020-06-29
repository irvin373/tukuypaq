package com.example.tukuypacandroid

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
//import com.example.tukuypacandroid.data.AppDatabase
import com.example.tukuypacandroid.data.RoomSingleton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard))
//        val db = RoomSingleton.getInstance(applicationContext);
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        populateDB(db)
    }

    private fun populateDB(db: RoomSingleton) {
        GlobalScope.launch {
//            db.medicalGroupDao().deleteAll()
//            db.plantDao().deleteAll()
//            val seed = Seed()
//            db.medicalGroupDao().insert(seed.getAllGroups())
//            db.plantDao().insert(seed.getAllPant())
            println("=================")
            val plants = db.plantDao().getPlantsWithGroup()
            plants.forEach {
                println("${it.group.name} ${it.plant.name}")
            }
        }
    }
}