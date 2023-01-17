package com.example.feelfit

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.feelfit.databinding.ActivityLoginffBinding
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

            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val userEmail = email //

            editor.putString("user_email", userEmail)
            editor.apply()



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

