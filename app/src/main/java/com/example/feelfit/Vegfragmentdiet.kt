package com.example.feelfit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class VegfragmentDiet : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyFirebaseRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_vegdiet, container, false)

        recyclerView = view.findViewById(R.id.RecyclerViewDietFragment)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        // Create the FirebaseRecyclerOptions object
        val ref = FirebaseDatabase.getInstance().getReference("Diet").child("Veg")
        Log.e("PIPI", "onCreateView: $ref", )
        val options = FirebaseRecyclerOptions.Builder<VegDModel>()
            .setQuery(ref, VegDModel::class.java)
            .build()
        Log.e("kkkkk", "onCreateView: ${options.snapshots}")


        // Create the adapter
        adapter = MyFirebaseRecyclerAdapter(options)
        // Set the adapter to the RecyclerView
        recyclerView.adapter = adapter

        return view
    }
    override fun onStart() {
        super.onStart()
        // Start listening for changes to the data
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        // Stop listening for changes to the data
        adapter.stopListening()
    }




}