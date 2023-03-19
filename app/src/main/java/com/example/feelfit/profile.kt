package com.example.feelfit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feelfit.Dashboard.BmiCalculator
import com.example.feelfit.Dashboard.Dashboard
import com.example.feelfit.RoomDB.AppDatabase
import com.example.feelfit.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


lateinit var firebaseAuth: FirebaseAuth

@SuppressLint("StaticFieldLeak")
private var _binding: FragmentProfileBinding? = null
lateinit var InsDB: AppDatabase

class profile : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        _binding = FragmentProfileBinding.inflate(inflater,container, false)

        firebaseAuth= FirebaseAuth.getInstance()
        var user=firebaseAuth.currentUser?.email

        _binding!!.reccalculatebmi.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, BmiCalculator::class.java)
            startActivity(intent)

        })

        InsDB = AppDatabase.getDatabase((Dashboard()))

        GlobalScope.launch(Dispatchers.IO) {

            val enties = user?.let { InsDB.userInfoDao().getAll(it) }
            launch(Dispatchers.Main) {

                _binding!!.getemail.text = enties!![0].email
                _binding!!.gen.text = enties[0].gender
                _binding!!.height1.text = enties[0].height
                _binding!!.weight1.text = enties[0].weight
                _binding!!.age1.text = enties[0].age
                _binding!!.body.text = enties[0].body
                _binding!!.bmi.text = enties[0].bmi

            }
        }
        return _binding!!.root



    }

    }



