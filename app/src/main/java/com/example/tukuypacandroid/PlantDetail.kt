package com.example.tukuypacandroid

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.tukuypacandroid.data.RoomSingleton
import com.example.tukuypacandroid.data.model.PlantWithGroup
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class PlantDetail : Fragment() {

    private var plant: PlantWithGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.plant_detail_fragment, container, false)
        val safeArgs: PlantDetailArgs by navArgs()
        val plantId = safeArgs.plantIdNumber
        this.getDetailData(root, container?.context as Context, plantId)
        return root
    }

    private fun getDetailData(root: View, context: Context, plantId: Int) {
        val textView: TextView = root.findViewById(R.id.titleName)
        GlobalScope.async {
            val db = RoomSingleton.getInstance(context)
            plant = db.plantDao().getSinglePlants(plantId)
            println("here ${plant?.group?.name} ${plant?.plant?.name}")
            textView.text = plant?.group?.name ?: "waiting"
        }
    }
}