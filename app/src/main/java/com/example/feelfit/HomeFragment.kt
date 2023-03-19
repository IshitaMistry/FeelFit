package com.example.feelfit

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import com.example.feelfit.Dashboard.BmiCalculator
import com.example.feelfit.RoomDB.AppDatabase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var InsDB: AppDatabase

    lateinit var bmi1:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view= inflater.inflate(R.layout.fragment_home2, container, false)


callpopUp()

        firebaseAuth = FirebaseAuth.getInstance()
        var user = firebaseAuth.currentUser?.email

        InsDB = AppDatabase.getDatabase(requireActivity())
        GlobalScope.launch(Dispatchers.IO) {
            val enties = user?.let { InsDB.userInfoDao().getAll(it) }
            launch(Dispatchers.Main) {
                if (enties!!.isNotEmpty()) {
                 //  bmi1 = enties!![0].bmi
                }
//                else {
//                    callpopUp()
//                }
            }
        }

        return view
    }
     fun callpopUp() {

         firebaseAuth = FirebaseAuth.getInstance()
         var user = firebaseAuth.currentUser?.email

         InsDB = AppDatabase.getDatabase(requireActivity())
         GlobalScope.launch(Dispatchers.IO) {
             val enties = user?.let { InsDB.userInfoDao().getAll(it) }
             launch(Dispatchers.Main) {
                 if (enties!!.isNotEmpty()) {
                       bmi1 = enties!![0].bmi
                 }
                else {

                     val dialog= Dialog(requireActivity())
                     dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                     dialog.setCancelable(false)
                     dialog.setContentView(R.layout.pop_up)

                     dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                     var button1=dialog.findViewById<Button>(R.id.buttonCalculate)
                     button1.setOnClickListener(View.OnClickListener {
                         startActivity(Intent(activity, BmiCalculator::class.java))
                     })

                     dialog.show()


                 }

                }
             }
         }

}