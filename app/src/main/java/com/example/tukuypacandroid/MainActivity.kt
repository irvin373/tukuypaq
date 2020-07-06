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
import com.example.tukuypacandroid.data.Seed
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard))
        val db = RoomSingleton.getInstance(applicationContext);
        populateDB(db)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun populateDB(db: RoomSingleton) {
        GlobalScope.async {
            val medicalGroups = db.medicalGroupDao().getAll()
            println("==== ${medicalGroups.size} =====")
            if (medicalGroups.isEmpty()) {
//                db.medicalGroupDao().deleteAll()
//                db.plantDao().deleteAll()
                val seed = Seed()
                db.medicalGroupDao().insert(seed.getAllGroups())
                db.plantDao().insert(seed.getAllPant())
                db.recipeDao().insert(seed.getAllRecipes())
            }
        }
    }
}