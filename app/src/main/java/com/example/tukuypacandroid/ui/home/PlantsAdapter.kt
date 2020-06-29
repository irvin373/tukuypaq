package com.example.tukuypacandroid.ui.home

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tukuypacandroid.R
import com.example.tukuypacandroid.data.model.PlantWithGroup
import kotlinx.android.synthetic.main.plant_list_item.view.*
import java.io.IOException

class PlantsAdapter(private val items : List<PlantWithGroup>)
    : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.title.text = items[position].plant.name
        holder.itemView.group.text = items[position].group.name
//        holder.itemView.description.text = items[position].description

        val assetsBitmap: Bitmap? = getBitmapFromAssets(items[position].plant.imgDir as String, holder.itemView.context)
        holder.itemView.plant_item_image.setImageBitmap(assetsBitmap)
        holder.itemView.card_view.setOnClickListener{view ->
//            val action = plantListDirections.actionPlantListToPlantDetail(position)
//            view.findNavController().navigate(action)
//            view.findNavController().navigate(action)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.plant_list_item, parent, false)
        return ViewHolder(view)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
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

class ViewHolder (containerView: View) : RecyclerView.ViewHolder(containerView) {
    val title = containerView.title
    val group = containerView.group
    //    val description = containerView.description
    val img = containerView.plant_item_image
}