package com.example.feelfit.Credentials
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.feelfit.Dashboard.Dashboard
import com.example.feelfit.databinding.ActivityLogin2Binding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLogin2Binding
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Regis.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.BtnRegister.setOnClickListener {
            val email = binding.EmailRegister.text.toString().trim()
            val pass = binding.PasswordRegister.text.toString().trim()



            firebaseAuth = FirebaseAuth.getInstance()


            if (email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if (it.isSuccessful){

                        val intent = Intent(this@Login, Dashboard::class.java)
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