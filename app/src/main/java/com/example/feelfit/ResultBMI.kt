package com.example.feelfit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.feelfit.databinding.ActivityResultBmiBinding
import com.google.firebase.auth.FirebaseAuth
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



    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("ResourceAsColor", "SetTextI18n", "LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth= FirebaseAuth.getInstance()
        var email=firebaseAuth.currentUser?.email

        InsDB= AppDatabase.getDatabase(this)


        var intent:Intent = intent
        height = intent.getStringExtra("height")
        weight = intent.getStringExtra("weight")
        var age=intent.getStringExtra("age")
        var height1=intent.getStringExtra("height1")
        var weight1=intent.getStringExtra("weight2")



        intheight = height!!.toFloat()
        intweight = weight!!.toFloat()

        intheight = intheight /100


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
            Log.e("shubh", "show :$body " )


            GlobalScope.launch (Dispatchers.IO){
                email?.let { InsDB.userInfoDao().Update(it,bmi,body,gender,age,height,weight) }

            }
            //binding.contentLayout.setBackgroundColor(R.color.lightblue)


        if(intbmi >=15 && intbmi <=18.4) {
            intent=Intent(this,Exercise2
            ::class.java)
            startActivity(intent)

        }else if(intbmi >=18.5 && intbmi <=24.9){
            intent=Intent(this,NormalActivity::class.java)
            startActivity(intent)


        }else if (intbmi > 24.9 ){
            intent=Intent(this,ExerciseI::class.java)
            startActivity(intent)

        }else{

        }

        }


    }
}