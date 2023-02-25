package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.feelfit.RoomDB.AppDatabase
import com.example.feelfit.RoomDB.InfoEntityC
import com.example.feelfit.databinding.ActivityShowProfileBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShowProfileAct : AppCompatActivity() {


    private lateinit var firebaseAuth: FirebaseAuth


    lateinit var binding: ActivityShowProfileBinding
    lateinit var InsDB: AppDatabase
    var UserList = listOf<InfoEntityC>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_profile)




        binding = ActivityShowProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth= FirebaseAuth.getInstance()
        var user=firebaseAuth.currentUser?.email




        binding.reccalculatebmi.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, BmiCalculator::class.java))
        })



        InsDB = AppDatabase.getDatabase(this@ShowProfileAct)


        GlobalScope.launch(Dispatchers.IO) {

                val enties = user?.let { InsDB.userInfoDao().getAll(it) }
                launch(Dispatchers.Main) {

                    binding.getemail.text = enties!![0].email
                    binding.gen.text = enties[0].gender
                    binding.height1.text = enties[0].height
                    binding.weight1.text = enties[0].weight
                    binding.age1.text = enties[0].age
                    binding.body.text = enties[0].body
                    binding.bmi.text = enties[0].bmi

                }

        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(applicationContext,Dashboard::class.java))
        finish()
    }
}