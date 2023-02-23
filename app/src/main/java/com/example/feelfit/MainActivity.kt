package com.example.feelfit
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.feelfit.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Login.setOnClickListener(View .OnClickListener {
            intent= Intent(this,Login::class.java)
            startActivity(intent)
        })
        // validation Start from here

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnregis23.setOnClickListener(View.OnClickListener {

            val name=binding.nameRegister.text.toString()

            val email=binding.EmailRegister.text.toString()
            val pass =binding.PasswordRegister.text.toString()
            val cnfpass=binding.cnfPasswordRegister.toString()



            firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                if(it.isSuccessful){
                    database=FirebaseDatabase.getInstance().getReference("Users")
                    val User=Users(name,email,pass)
                    database.child(name).setValue(User).addOnCompleteListener {
                        Toast.makeText(this,"Successfully saved",Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {
                        Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()

                    }
                    intent=Intent(this,Login::class.java)
                    startActivity(intent)
                }else{

                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }

//            if (email.isNotEmpty()&& cnfpass.isNotEmpty()&& name.isNotEmpty()){
//                if (pass==cnfpass){
//
//
//
//                }else{
//                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
//                }
//
//            }else{
//                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
//            }

        })

    }
}