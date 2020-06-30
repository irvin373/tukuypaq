package com.example.tukuypacandroid

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.tukuypacandroid.data.RoomSingleton
import com.example.tukuypacandroid.data.model.PlantWithGroup
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class PlantDetail : Fragment() {

    companion object {
        fun newInstance() = PlantDetail()
    }

    private lateinit var viewModel: PlantDetailViewModel
    private var plant: PlantWithGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.plant_detail_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.titleName)
        val safeArgs: PlantDetailArgs by navArgs()
        val plantId = safeArgs.plantIdNumber
        println("--> ${plantId}")
        GlobalScope.async {
            val db = RoomSingleton.getInstance(container?.context as Context)
            plant = db.plantDao().getSinglePlants(plantId)
            viewModel.setPlant(plant)
            viewModel.plant.observe(viewLifecycleOwner, Observer {
                textView.text = plant?.group?.name ?: "waiting"
                print("here ${plant?.group?.name} ${plant?.plant?.name}")
            })
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlantDetailViewModel::class.java)
        viewModel.plant.observe(viewLifecycleOwner, Observer {

            print("here ${plant?.group?.name} ${plant?.plant?.name}")
        })
        // TODO: Use the ViewModel
    }

}