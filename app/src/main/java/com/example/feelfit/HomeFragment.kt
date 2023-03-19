package com.example.feelfit

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.feelfit.Dashboard.Dashboard
import com.example.feelfit.RoomDB.AppDatabase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var InsDB: AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_home2, container, false)



        firebaseAuth = FirebaseAuth.getInstance()
        var user = firebaseAuth.currentUser?.email
        Log.e("Sahil", "+++++++++: "+user )


        val getemail1=view.findViewById<TextView>(R.id.getemail)
        val gen1=view.findViewById<TextView>(R.id.gen)
        val height=view.findViewById<TextView>(R.id.height1)
        val weight=view.findViewById<TextView>(R.id.weight1)
        val age=view.findViewById<TextView>(R.id.age1)
        val body=view.findViewById<TextView>(R.id.body)
        val bmi=view.findViewById<TextView>(R.id.bmi)

        InsDB = AppDatabase.getDatabase(requireActivity())

        GlobalScope.launch(Dispatchers.IO) {
            val enties = user?.let { InsDB.userInfoDao().getAll(it) }
            Log.e("hello", "============"+enties )
            launch(Dispatchers.Main) {
                if (enties!!.isEmpty()) {
                    getemail1.text = enties!![0].email
                    gen1.text = enties[0].gender
                    height.text = enties[0].height
                    weight.text = enties[0].weight
                    age.text = enties[0].age
                    body.text = enties[0].body
                    bmi.text = enties[0].bmi
                }
            }
        }



        return view
    }


}