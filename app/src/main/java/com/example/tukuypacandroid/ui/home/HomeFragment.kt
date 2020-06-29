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
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private lateinit var adapter: PlantsAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        GlobalScope.async {
            val db = RoomSingleton.getInstance(container?.context as Context);
            val plants = db.plantDao().getPlantsWithGroup()
            adapter = PlantsAdapter(plants)
            plantlistView.adapter = adapter
        }
        return root
    }
}