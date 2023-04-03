package com.example.feelfit
import android.annotation.SuppressLint
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
import android.widget.TextView
import android.widget.Toast
import com.example.feelfit.Dashboard.BmiCalculator
import com.example.feelfit.RoomDB.AppDatabase
import com.example.feelfit.databinding.FragmentHome2Binding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHome2Binding

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
        binding = FragmentHome2Binding.inflate(inflater,container,false)
        val view= inflater.inflate(R.layout.fragment_home2, container, false)

        val calendar = Calendar.getInstance()
        @SuppressLint("SimpleDateFormat")
        val dateFormat = SimpleDateFormat("EEEE, d MMM")
        val currentDate = dateFormat.format(calendar.time)
        Log.e("sahhhiilll", "onCreateView: $currentDate", )

        val dashboardDate = view.findViewById<TextView>(R.id.CurrentStatus)
        dashboardDate.text = currentDate


        callpopUp()

        firebaseAuth = FirebaseAuth.getInstance()


        val user = firebaseAuth.currentUser?.email

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
//             if (enties!!.isEmpty()){
//                 Toast.makeText(activity,"Calculate your bmi", Toast.LENGTH_SHORT).show()
//             }
//             else
//             {
//                 binding.bmiDashboard.text = enties[0].bmi
//                 binding.weightDashboard.text = enties[0].weight
//                 binding.heightDashboard.text = enties[0].height
//                 binding.genderDashboard.text = enties[0].gender
//             }
             }
         }

}