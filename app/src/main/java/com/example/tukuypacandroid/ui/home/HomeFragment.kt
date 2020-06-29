package com.example.tukuypacandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tukuypacandroid.R

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: MedicalGroupViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = MedicalGroupListAdapter(container?.context!!)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(container?.context!!)
        homeViewModel = ViewModelProvider(this).get(MedicalGroupViewModel::class.java)
        homeViewModel.allgroups.observe(viewLifecycleOwner, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.setWords(it) }
        })
        return root
    }
}

//class HomeFragment : Fragment() {
//
//    //    private lateinit var homeViewModel: HomeViewModel
//    private lateinit var homeViewModel: MedicalGroupViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
////        homeViewModel =
////                ViewModelProviders.of(this).get(HomeViewModel::class.java)
////        val root = inflater.inflate(R.layout.fragment_home, container, false)
////        val textView: TextView = root.findViewById(R.id.text_home)
////        homeViewModel.text.observe(viewLifecycleOwner, Observer {
////            textView.text = it
////        })
//        return root
//    }
//}