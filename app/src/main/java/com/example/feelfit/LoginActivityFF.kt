package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.inflate
import android.widget.Toast
import com.example.feelfit.databinding.ActivityLoginffBinding
import com.example.feelfit.databinding.ActivityLoginffBinding.inflate
import com.google.firebase.auth.FirebaseAuth

class LoginActivityFF : AppCompatActivity() {
private lateinit var binding: ActivityLoginffBinding
private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginffBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Regis.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.BtnRegister.setOnClickListener {
            val email = binding.EmailRegister.text.toString()
            val pass = binding.PasswordRegister.text.toString()



            firebaseAuth = FirebaseAuth.getInstance()

            if (email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if (it.isSuccessful){

                        val intent = Intent(this, DashBoard::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            }
            else{
                Toast.makeText(this, "Password is not Matching", Toast.LENGTH_SHORT).show()
            }
        }


    }
}

