package com.example.tukuypacandroid.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tukuypacandroid.R
import com.example.tukuypacandroid.data.RoomSingleton
import com.example.tukuypacandroid.data.model.PlantWithGroup
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class HomeFragment : Fragment() {

    private lateinit var plantViewModel: HomeViewModel
    private lateinit var adapter: PlantsAdapter
    private lateinit var plantsList: List<PlantWithGroup>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        plantsList = emptyList()
        plantViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        this.getPlants(container?.context as Context)
        plantViewModel.plants.observe(viewLifecycleOwner, Observer {
            adapter = PlantsAdapter(plantsList)
            plantlistView.adapter = adapter
        })
        return root
    }

    private fun getPlants(container: Context) {
        GlobalScope.async {
            // do work here ...
            val db = RoomSingleton.getInstance(container);
            val plants = db.plantDao().getPlantsWithGroup()
            plantsList = plants
            adapter = PlantsAdapter(plantsList)
            plantlistView.adapter = adapter
        }
    }

}
