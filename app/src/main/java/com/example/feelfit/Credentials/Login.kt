package com.example.feelfit.Credentials
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        emailFocusListener()
        passwordFocusListener()



        binding.Regis.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }





        binding.BtnRegister.setOnClickListener {

            submitForm()

            val builder= AlertDialog.Builder(this@Login)

            val progressBar= ProgressBar(this@Login)
            progressBar.isIndeterminate=true
            builder.setView(progressBar)

            val dialog=builder.create()
            dialog.show()

            Handler().postDelayed({ // Hide the progress bar
                progressBar.visibility = View.GONE
                Handler().postDelayed({ dialog.dismiss() }, 1000)
            }, 3000)
//



        }
    }

    private fun submitForm() {
        firebaseAuth = FirebaseAuth.getInstance()


        binding.Emaili.helperText=validEmail()
        binding.txtInputPass1.helperText=validPassword()
        val validemail=binding.Emaili.helperText==null
        val validpass=binding.txtInputPass1.helperText==null
        if (validemail && validpass) {
            val email = binding.EmailRegister.text.toString().trim()
            val pass = binding.PasswordRegister1.text.toString().trim()

            firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                if (it.isSuccessful) {

                    val intent = Intent(this@Login, Dashboard::class.java)
                    startActivity(intent)


                } else {
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                }
            }
        } else {
            Toast.makeText(this, "Password is not Matching", Toast.LENGTH_SHORT).show()
        }


    }

    private fun passwordFocusListener() {
        binding.PasswordRegister1.setOnFocusChangeListener{View,focused ->

            if (!focused){
                binding.txtInputPass1.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {


        val passwordText = binding.PasswordRegister1.text.toString().trim()
        if(passwordText.length < 8)
        {
            return "Enter Correct  Password"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 Upper-case Character"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 Lower-case Character"
        }
        if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex()))
        {
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }
        return null

    }

    private fun emailFocusListener() {
        binding.EmailRegister.setOnFocusChangeListener { View, focused ->
            if (!focused) {
                binding.Emaili.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val email = binding.EmailRegister.text.toString().trim()
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return "Invalid Email Address"
        }
       return null

    }

}
