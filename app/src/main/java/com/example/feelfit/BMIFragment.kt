package com.example.feelfit

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.PopupWindow
import android.widget.Toast
import com.example.feelfit.Dashboard.BmiCalculator
import com.example.feelfit.GainingExercises.Exercise2
import com.example.feelfit.LosingExercise.ExerciseI
import com.example.feelfit.NormalExercise.NormalActivity
import com.example.feelfit.R
import com.example.feelfit.RoomDB.AppDatabase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class BMIFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var InsDB: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_b_m_i, container, false)
        firebaseAuth = FirebaseAuth.getInstance()
        val user=firebaseAuth.currentUser?.email

        InsDB = AppDatabase.getDatabase(Activity())
        GlobalScope.launch(Dispatchers.IO) {

            Log.e("henil", "=========>: "+user )
            val enties = user?.let { InsDB.userInfoDao().getAll(it) }
            Log.e("mello", "Shubh: $enties" + "" )
            launch(Dispatchers.Main) {
                if (enties!!.isEmpty()) {

                }
//               else {
//
//                    val body = enties?.get(0)?.body.toString()
//
//                    if (body == "SEVERE SKINNY") {
//                        startActivity(Intent(activity, Exercise2::class.java))
//                    }
//                    if (body == "MODERATE SKINNY") {
//                        startActivity(Intent(activity, Exercise2::class.java))
//
//                    }
//                    if (body == "MODERATE SKINNY") {
//                        startActivity(Intent(activity, Exercise2::class.java))
//
//
//                    }
//                    if (body == "MILD THINNESS") {
//                        startActivity(Intent(activity, Exercise2::class.java))
//
//
//                    }
//                    if (body == "NORMAL") {
//                        startActivity(
//                            Intent(activity, NormalActivity::class.java))
//
//                    }
//                    if (body == "OVERWEIGHT") {
//                        startActivity(Intent(activity, ExerciseI::class.java))
//
//                    }
//                    if (body == "OBESE I") {
//                        startActivity(Intent(activity, ExerciseI::class.java))
//
//                    }
//                    if (body == "OBESE II") {
//                        startActivity(Intent(activity, ExerciseI::class.java))
//
//                    } else {
//
//                    }
//                }
            }
        }

        return  view
    }

    private fun callpopup() {
        val dialog= Dialog(this.requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.pop_up)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        var button1=dialog.findViewById<Button>(R.id.buttonCalculate)
        button1.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity,BmiCalculator::class.java))
            dialog.dismiss()
        })

        dialog.show()



    }


}