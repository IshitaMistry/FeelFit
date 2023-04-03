package com.example.feelfit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feelfit.Adapter.customAdapter
import com.example.feelfit.Dashboard.Dashboard
import com.example.feelfit.LosingExercise.*
import java.util.ArrayList

class ExerciseLosing : Fragment(), customAdapter.MyClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_exercise_losing, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view1)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        val data = ArrayList<itemview>()

        data.add(itemview(R.drawable.gain1, R.drawable.jog, "RUNNING"))
        data.add(itemview(R.drawable.gain2, R.drawable.plank, "PLANK"))
        data.add(itemview(R.drawable.gain3, R.drawable.jumpingrope, "JUMP ROPE"))
        data.add(itemview(R.drawable.gain4, R.drawable.burpeesexercise, "BURPESS"))
        data.add(itemview(R.drawable.gain5, R.drawable.pushup, "PUSHUP"))
        data.add(itemview(R.drawable.gain6, R.drawable.crunchess, "CRUNCHES"))
        data.add(itemview(R.drawable.seven, R.drawable.no, "INTERMITENT\n FASTING"))

        val adapter = customAdapter(data, this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        val back = view.findViewById<ImageView>(R.id.backpress253)

        back.setOnClickListener{

            var int=Intent(activity,Dashboard::class.java)
            int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(int)
        }

        return view

    }

    override fun onClick(position: Int) {
        when(position)
        {
            0 -> {
                val int=Intent(activity,Exercise_details_one::class.java)
                int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(int)
            }
            1 -> {
                val int=Intent(activity,Exercise_details_two::class.java)
                int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(int)
            }

            2 -> {
                val int=Intent(activity,Exercise_details_three::class.java)
                int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(int)
            }

            3 -> {
                val int=Intent(activity,Exercise_details_four::class.java)
                int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(int)
            }

            4 -> {
                val int=Intent(activity,Exercise_details_five::class.java)
                int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(int)
            }

            5 -> {
                val int=Intent(activity,Exercise_details_six::class.java)
                int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(int)
            }

            6 -> {
                val int=Intent(activity,IntermittentPlan::class.java)
                int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(int)
            }
        }
    }
}