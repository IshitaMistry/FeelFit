package com.example.feelfit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.feelfit.databinding.ActivityBmiresultBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.collection.LLRBNode.Color
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ResultBMI : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var binding: ActivityBmiresultBinding
    var intbmi = 0f
    var height: String? = null
    var weight: String?= null
    var intheight = 0f
    var intweight = 0f
    var mbmi: String? = null

    lateinit var InsDB: AppDatabase



    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBmiresultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent:Intent
        intent=getIntent()


        height=intent.getStringExtra("height")
        weight = intent.getStringExtra("weight")



        intheight = height!!.toFloat()
        intweight = weight!!.toFloat()
        intheight = intheight / 100
        intbmi = intweight / (intheight * intheight)
        mbmi = java.lang.Float.toString(intbmi)
        println(mbmi)


        firebaseAuth= FirebaseAuth.getInstance()
        var email=firebaseAuth.currentUser?.email


    //    var underweight=findViewById<TextView>(R.id.text_UnderWeight)

        InsDB= AppDatabase.getDatabase(this)



        if (intbmi <=16 ){

            binding.textUnderWeight.setText("Severe Skinny")
            binding.contentLayout.background=resources.getDrawable(R.color.green)
        }
        else if(intbmi <=16.9 && intbmi >= 16)
        {
            binding.textUnderWeight.setText("Moderate Skinny")
            binding.contentLayout.background=resources.getDrawable(R.color.orange)

        }
        else if (intbmi <= 18.4 && intbmi >= 17){
            binding.textUnderWeight.setText("Mild Thinness")
            binding.contentLayout.background=resources.getDrawable(R.color.blue)


        }else if (intbmi <= 24.9 && intbmi >= 18.456)

        {
            binding.textUnderWeight.setText("Normal")
            binding.contentLayout.background=resources.getDrawable(R.color.grey)

        } else if ( intbmi <= 29.9 &&  intbmi >= 25 ){
            binding.textUnderWeight.setText(" Over weight!!")
            binding.contentLayout.background=resources.getDrawable(R.color.babyred)


        } else if ( intbmi <= 34.9 && intbmi >= 30)
        {
            binding.textUnderWeight.setText(" obese class I")
            binding.contentLayout.background=resources.getDrawable(R.color.red)

        } else {
            binding.textUnderWeight.setText( "obese class II")
            binding.contentLayout.background=resources.getDrawable(R.color.darkred)

        }

        binding.gender.setText(intent.getStringExtra("gender"))
        binding.resultBmi.setText(mbmi)


        binding.Proceed.setOnClickListener(View.OnClickListener {
            val bmi=intbmi.toFloat().toString()

            var body=binding.textUnderWeight.text.toString()
             val gender=binding.gender.text.toString()
            val height1=weight.toString()



            Log.e("shubh", "show :$body " )
            GlobalScope.launch (Dispatchers.IO){
                email?.let { InsDB.userInfoDao().Update(it,bmi,body,gender,height1) }

            }

            if(intbmi >=16 && intbmi <=18.4) {
                intent=Intent(this,GainingActivity
                ::class.java)
                startActivity(intent)

            }else if(intbmi >=18.5 && intbmi <=24.9){
                intent=Intent(this,NormalActivity::class.java)
                startActivity(intent)


            }else if (intbmi > 24.9 ){
                intent=Intent(this,Losing_Exercise::class.java)
                startActivity(intent)

            }else{

            }


        })

    }
}