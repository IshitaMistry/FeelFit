package com.example.feelfit
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.feelfit.databinding.ActivityShowProfileBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShowProfileAct : AppCompatActivity() {


    lateinit var binding: ActivityShowProfileBinding
    lateinit var InsDB: AppDatabase
    var UserList = listOf<InfoEntityC>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShowProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.reccalculatebmi.setOnClickListener(View.OnClickListener {

            startActivity(Intent(this, BmiCalculator::class.java))
        })


        InsDB = AppDatabase.getDatabase(this@ShowProfileAct)


        GlobalScope.launch(Dispatchers.IO) {

            val enties = InsDB.userInfoDao().getAll()

            binding.getemail.text = enties[0].email
            binding.gen.text = enties[1].gender
//            binding.height1.text = enties[2].height
//            binding.weight1.text = enties[3].weight
//            binding.age1.text = enties[4].age
//            binding.body.text = enties[5].body
//            binding.bmi.text = enties[6].bmi
        }

    }

}