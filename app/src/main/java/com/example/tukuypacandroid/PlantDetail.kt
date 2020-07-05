package com.example.tukuypacandroid

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.tukuypacandroid.data.RoomSingleton
import com.example.tukuypacandroid.data.model.PlantWithGroup
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.io.IOException

class PlantDetail : Fragment() {

    private var plant: PlantWithGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.plant_detail_fragment, container, false)
        val safeArgs: PlantDetailArgs by navArgs()
        val plantId = safeArgs.plantIdNumber + 1
        this.getDetailData(root, container?.context as Context, plantId)
        return root
    }

    private fun getDetailData(root: View, context: Context, plantId: Int) {
        val textViewName: TextView = root.findViewById(R.id.titleName)
        val textViewGroup: TextView = root.findViewById(R.id.groupName)
        val textViewDescription: TextView = root.findViewById(R.id.description)
        val imageView: ImageView = root.findViewById(R.id.image)
        GlobalScope.async {
            val db = RoomSingleton.getInstance(context)
            plant = db.plantDao().getSinglePlants(plantId)
            println("here ${plant?.group?.name} ${plant?.plant?.name}")
            textViewName.text = plant?.plant?.name ?: "waiting"
            textViewGroup.text = plant?.group?.name ?: "waiting"
            textViewDescription.text = plant?.plant?.description ?: "waiting"
            val assetBitmap: Bitmap? = getBitmapFromAssets(plant?.plant?.imgDir as String, context)
            imageView.setImageBitmap(assetBitmap)
        }
    }

    private fun getBitmapFromAssets(fileName: String, context: Context): Bitmap? {
        return try {
            BitmapFactory.decodeStream(context.assets.open(fileName))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}