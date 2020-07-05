package com.example.tukuypacandroid.ui.home

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tukuypacandroid.R
import com.example.tukuypacandroid.data.RoomSingleton
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class HomeFragment : Fragment() {

    private lateinit var adapter: PlantsAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        this.getPlants(container?.context as Context)
        return root
    }

    private fun getPlants(container: Context) {
        GlobalScope.async {
            // do work here ...
            val db = RoomSingleton.getInstance(container);
            val plants = db.plantDao().getPlantsWithGroup()
            adapter = PlantsAdapter(plants)
            plantlistView.adapter = adapter
        }
    }

}

class doAsync(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
    init {
        execute()
    }
    override fun doInBackground(vararg params: Void?): Void? {
        handler()
        return null
    }
}