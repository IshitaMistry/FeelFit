package com.example.feelfit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import com.example.feelfit.R
import com.example.feelfit.databinding.ActivityBmiCalculatorBinding
import com.google.firebase.auth.FirebaseAuth

class BmiCalculator : AppCompatActivity() {



    var intweight = 55
    var intage = 22
    var currentprogress = 0
    var mintprogress = "170"
    var typerofuser = "0"
    var weight2 = "55"
    var age2 = "22"


    private lateinit var binding: ActivityBmiCalculatorBinding
    private lateinit var firebaseAuth: FirebaseAuth
     var num=0
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBmiCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)


      binding.male.setOnClickListener(View.OnClickListener {

          typerofuser ="male"
          binding.cardMale.setBackgroundColor(R.color.grey)

      })
        binding.female.setOnClickListener(View.OnClickListener {
            binding.cardFemale.setBackgroundColor(R.color.grey)


            typerofuser ="female"

        })

        binding.seekbarforheight.setMax(300)
        binding.seekbarforheight.setProgress(170)
        binding.seekbarforheight.setOnSeekBarChangeListener(
            object : OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    currentprogress = progress
                    mintprogress = currentprogress.toString()
                    binding.currentheight.setText(mintprogress)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}
                override fun onStopTrackingTouch(seekBar: SeekBar) {}

            })
        binding.incremetweight.setOnClickListener(View.OnClickListener {
            intweight = intweight + 1
            weight2 = intweight.toString()
            binding.currentweight.setText(weight2)
        })

        binding.incrementage.setOnClickListener(View.OnClickListener {
            intage = intage + 1
            age2 = intage.toString()
            binding.currentage.setText(age2)
        })

        binding.decrementage.setOnClickListener(View.OnClickListener {
            intage=intage-1
            age2=intage.toString()
            binding.currentage.setText(age2)

        })
        binding.decrementweight.setOnClickListener(View.OnClickListener {
            intweight=intweight-1
            weight2=intweight.toString()
            binding.currentweight.setText(weight2)
        })

        binding.cardMale.setOnClickListener(View.OnClickListener {
        //    binding.cardMale.setCardBackgroundColor()

        })
       binding.cardFemale.setOnClickListener(View.OnClickListener {  })

        binding.calculatebmi.setOnClickListener(View.OnClickListener {

            if (typerofuser =="0"){
                Toast.makeText(applicationContext,"Select your gender ",Toast.LENGTH_SHORT).show()
            }else if (mintprogress== "0"){
                Toast.makeText(applicationContext, "Select Your Height First", Toast.LENGTH_SHORT)
                    .show()

            } else if (intage == 0 || intage < 0){
                Toast.makeText(applicationContext,"Age in invalid ",Toast.LENGTH_SHORT).show()

            } else if (intweight == 0 || intweight < 0){
                Toast.makeText(applicationContext,"Weight is Incorrect ",Toast.LENGTH_SHORT).show()
            }else{

                intent = Intent(this,ResultBMI::class.java)

                intent.putExtra("gender",typerofuser)
                intent.putExtra("height",mintprogress)
                intent.putExtra("weight",weight2)
                intent.putExtra("age",age2)
                startActivity(intent)



            }

        })












    }
}