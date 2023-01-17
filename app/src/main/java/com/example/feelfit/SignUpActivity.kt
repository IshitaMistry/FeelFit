package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.feelfit.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Login.setOnClickListener(View .OnClickListener {
            intent= Intent(this,LoginActivityFF::class.java)
            startActivity(intent)
        })
        // validation Start from here

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnregis23.setOnClickListener(View.OnClickListener {

            val name=binding.regisName.text.toString()

            val email=binding.Emailregis.text.toString()
            val pass =binding.PasswordRegister.text.toString()
            val cnfpass=binding.cnfPasswordRegister.text.toString()

            if (email.isNotEmpty()&& pass.isNotEmpty()&& cnfpass.isNotEmpty()&& name.isNotEmpty()){
                if (pass==cnfpass){

                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                        if(it.isSuccessful){
                            intent=Intent(this,LoginActivityFF::class.java)
                            startActivity(intent)
                        }else{

                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }

        })
    }
}