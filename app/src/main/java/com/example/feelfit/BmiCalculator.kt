package com.example.feelfit
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.feelfit.databinding.ActivityBmiCalculatorBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BmiCalculator : AppCompatActivity()
{
    private lateinit var binding: ActivityBmiCalculatorBinding

    lateinit var InsDB: AppDatabase
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser
    var intweight = 55
    var intage = 22
    var currentprogess = 0
    var mintprogress = "170"
    var weight2 = "55"
    var age2 = "22"
    lateinit var radioButton: RadioButton



    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth= FirebaseAuth.getInstance()
        var user=auth.currentUser?.email


        binding.seekbar.setMax(300)
        binding.seekbar.setProgress(170)
        binding.seekbar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener
            {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    currentprogess = progress
                    mintprogress = currentprogess.toString()
                    binding.seekHeight.setText(mintprogress)
                }

                override fun onStartTrackingTouch(p0: SeekBar?){}

                override fun onStopTrackingTouch(p0: SeekBar?){}
            })
        binding.plus.setOnClickListener {
            intweight = intweight+1
            weight2=intweight.toString()
            binding.showweight.setText(weight2)
        }
        binding.AgePlus.setOnClickListener {
            intage=intage+1
            age2=intage.toString()
            binding.showage.setText(age2)
        }
        binding.minus.setOnClickListener {
            intweight = intweight-1
            weight2=intweight.toString()
            binding.showweight.setText(weight2)
        }
        binding.AgeMinus.setOnClickListener {
            intage=intage-1
            age2=intage.toString()
            binding.showage.setText(age2)
        }





        fun Writedata() {

            var email=user.toString()
        //    Log.e("123", "--------->>>$gender")
            val height=mintprogress.toInt().toString()
            val weight=binding.showweight.text.toString()
            val age=binding.showage.text.toString()

//            val gender=radioButton.text.toString()
//            Log.e("shubh", "========>>"+gender )

            InsDB= AppDatabase.getDatabase(this)

            GlobalScope.launch {(Dispatchers.IO)
                InsDB.userInfoDao().insert(InfoEntityC(email,null ,height,weight,age,null.toString(), null.toString()))

            }

        }


        binding.calculateButton.setOnClickListener {

            Writedata()

            if (binding.btn.checkedRadioButtonId==-1)
            {
                Toast.makeText(applicationContext,"Select Your Gender",Toast.LENGTH_SHORT).show()
            }
            else if (mintprogress=="0")
            {
                Toast.makeText(applicationContext,"Select Your Height First",Toast.LENGTH_SHORT).show()
            }
            else if (intage == 0 || intage < 0)
            {
                Toast.makeText(applicationContext,"Age is Invalid",Toast.LENGTH_SHORT).show()
            }
            else if (intweight == 0 || intweight<0)
            {
                Toast.makeText(applicationContext,"Weight is InCorrect",Toast.LENGTH_SHORT).show()
            }
            else
            {
                intent = Intent(this,ResultBMI::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                val intSelectButton: Int = binding.btn!!.checkedRadioButtonId
                radioButton = findViewById(intSelectButton)

                Log.e("parthi","===========>>"+radioButton.text)
                intent.putExtra("weight",binding.showweight.text.toString())
                intent.putExtra("age",binding.showage.text.toString())
                intent.putExtra("height1",binding.seekHeight.text.toString())
                intent.putExtra("weight2",binding.showweight.text.toString())
                intent.putExtra("gender",radioButton.text)
                intent.putExtra("height",mintprogress)
                intent.putExtra("weight",weight2)
                intent.putExtra("age",age2)
                startActivity(intent)
            }
        }


    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,Dashboard::class.java))
        finish()
    }

}
