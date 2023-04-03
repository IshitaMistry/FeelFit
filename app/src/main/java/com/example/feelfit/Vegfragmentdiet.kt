package com.example.feelfit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.inappmessaging.model.ImageData

class VegfragmentDiet : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vegdiet, container, false)


        val myRecyclerView: RecyclerView = view.findViewById(R.id.RecyclerViewDietFragment)

        val bookList = mutableListOf<NonVegF>()
        val adapter = NonVegFDietAdapter(bookList)
        myRecyclerView.adapter = adapter

        val database = FirebaseDatabase.getInstance()
        var vegR = database.getReference("Diet").child("Veg").child("fruits")





        vegR.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val text = snapshot.child("amount").getValue(String::class.java)
                Log.e("sudhir", "++++++++:$text ", )
                val imageUrl = snapshot.child("img").getValue(String::class.java)
                Log.e("sushii", "++++++++++: $imageUrl" + "",)

                val img = NonVegF(text ?: "", imageUrl ?: "")
                bookList.add(img)
                adapter.notifyDataSetChanged()

            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {

            }

            override fun onChildRemoved(snapshot: DataSnapshot) {

            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }


        })
        return view

    }
}