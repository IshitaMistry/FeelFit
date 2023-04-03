package com.example.feelfit.Dashboard

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.feelfit.GainingExercises.Exercise2
import com.example.feelfit.LosingExercise.ExerciseI
import com.example.feelfit.NormalExercise.NormalActivity
import com.example.feelfit.RoomDB.AppDatabase
import com.example.feelfit.Users
import com.example.feelfit.databinding.ActivityResultBmiBinding
import com.firebase.ui.auth.data.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ResultBMI : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityResultBmiBinding
    var intbmi = 1.0f
    var height: String? = null
    var weight: String? = null
    var intheight = 1.0f
    var intweight = 1.0f
    var mbmi: String? =null

    lateinit var InsDB: AppDatabase

    private lateinit var database: DatabaseReference


    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("ResourceAsColor", "SetTextI18n", "LogNotTimber", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth= FirebaseAuth.getInstance()
        val email=firebaseAuth.currentUser?.email

        InsDB= AppDatabase.getDatabase(Dashboard())


        var intent:Intent = intent
        height = intent.getStringExtra("height")
        weight = intent.getStringExtra("weight")
        val age=intent.getStringExtra("age")
        val height1=intent.getStringExtra("height1")
        val weight1=intent.getStringExtra("weight2")


        intheight = height!!.toFloat()
        intweight = weight!!.toFloat()

        intheight /= 100
        intbmi = intweight/(intheight * intheight)
        mbmi = java.lang.Float.toString(intbmi)
        println(mbmi)

        if (intbmi < 16)
        {
            binding.textUnderWeight.setText("SEVERE SKINNY")
            binding.LossGain.setText("YOU NEED TO GAIN!!")
            //binding.contentLayout.setBackgroundColor(R.color.lightblue)
        }
        else if (intbmi < 16.9 && intbmi > 16)
        {
            binding.textUnderWeight.setText("MODERATE SKINNY")
            binding.LossGain.setText("YOU NEED TO GAIN!!")
            //binding.contentLayout.setBackgroundColor(R.color.lightblue)
        }
        else if (intbmi < 18.4 && intbmi > 17) {
            binding.textUnderWeight.setText("MILD THINNESS")
            binding.LossGain.setText("YOU NEED TO GAIN!!")

        }
        else if (intbmi < 24.9 && intbmi > 18.5)
        {
            binding.textUnderWeight.setText("NORMAL")
            binding.LossGain.setText("GOOD! YOU NEED MAINTAIN")
            //binding.contentLayout.setBackgroundColor(R.color.lightblue)

        }
        else if (intbmi < 29.9 &&  intbmi > 25)
        {
            binding.textUnderWeight.setText("OVERWEIGHT")
            binding.LossGain.setText("YOU NEED TO LOSE")
            //binding.contentLayout.setBackgroundColor(R.color.lightblue)
        }
        else if ( intbmi < 34.9 && intbmi > 30)
        {
            binding.textUnderWeight.setText("OBESE I")
            binding.LossGain.setText("YOU NEED TO LOSE")
            //binding.contentLayout.setBackgroundColor(R.color.lightblue)
        }
        else
        {
            binding.textUnderWeight.setText("OBESE II")
            binding.LossGain.setText("YOU NEED TO LOSE MORE")
            //binding.contentLayout.setBackgroundColor(R.color.lightblue)
        }

        binding.gender.setText(intent.getStringExtra("gender"))
        binding.resultBmi.setText(mbmi)

        binding.Proceed.setOnClickListener {
            val bmi=intbmi.toFloat().toString()
            val body=binding.textUnderWeight.text.toString()
            val gender=binding.gender.text.toString()
            val age=age.toString()
            val height=height1.toString()
            val weight=weight1.toString()

            val bmiText=bmi
            val bodyT=body
            val genderT=gender
            val ageT=age
            val heightT=height
            val weightT=weight



            updateFirebaseDB(bmiText, bodyT, genderT, ageT, heightT, weightT)



            GlobalScope.launch (Dispatchers.IO){
                email?.let { InsDB.userInfoDao().Update(it,bmi,body,gender,age,height,weight) }

            }
            //binding.contentLayout.setBackgroundColor(R.color.lightblue)

            if (intbmi <= 15){
                intent=Intent(
                    this, Exercise2::class.java)
                startActivity(intent)
                intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK)

                finish()
            }

        else if(intbmi >=15 && intbmi <=18.49) {
            intent=Intent(this, Exercise2
            ::class.java)
                startActivity(intent)
                intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK)

                finish()

        }else if(intbmi >=18.5 && intbmi <=24.9){
            intent=Intent(this, NormalActivity::class.java)
            startActivity(intent)
                intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK)

                finish()


        }else if (intbmi > 24.9 ){
            intent=Intent(this, ExerciseI::class.java)
            startActivity(intent)
                intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK)

                finish()

        }else{

        }


    }
    }



    private fun updateFirebaseDB(bmiText: String, bodyT: String, genderT: String,ageT:String,heightT:String,weightT:String ) {
        var uid=firebaseAuth?.uid
        database=FirebaseDatabase.getInstance().getReference("Users")
        val user= mapOf<String,String>(
            "age"    to ageT,
            "bmi"    to bmiText,
            "body"   to bodyT,
            "gender" to genderT,
            "height" to heightT,
            "weight" to weightT
        )
        if (uid != null) {
            database.child(uid).updateChildren(user).addOnSuccessListener {

            }.addOnFailureListener {
                Snackbar.make(binding.root,"Server Down !!",Snackbar.LENGTH_SHORT).show()

            }
    }
}
}