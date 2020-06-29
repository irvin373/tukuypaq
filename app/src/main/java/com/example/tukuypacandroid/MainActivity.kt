package com.example.tukuypacandroid

//import com.example.tukuypacandroid.data.AppDatabase
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Database
import androidx.room.Room
import com.example.tukuypacandroid.data.AppDatabase
import com.example.tukuypacandroid.data.model.MedicalGroup
//import com.example.tukuypacandroid.data.RoomSingleton
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private var db: RoomSingleton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "PlantDB.db"
        ).build()

    val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard))
//        db = RoomSingleton.getInstance(applicationContext)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        fab.setOnClickListener {view ->
            print("execute here")
        }
    }
}