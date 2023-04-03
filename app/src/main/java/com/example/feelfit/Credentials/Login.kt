package com.example.feelfit.Credentials
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.feelfit.Dashboard.Dashboard
import com.example.feelfit.databinding.ActivityLogin2Binding
import com.example.feelfit.progress.LoadingDialog
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLogin2Binding
    private lateinit var firebaseAuth: FirebaseAuth
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        emailFocusListener()
        passwordFocusListener()

//-------------------------------forget password-------------------------------------------------------------------//
//        binding.forgetpassword.setOnClickListener {
//            val builder: AlertDialog.Builder= AlertDialog.Builder(this)
//            builder.setTitle("Forgot Password")
//            val view =layoutInflater.inflate(R.layout.dialog_forgot_password,null)
//            val username: EditText =view.findViewById(R.id.Resetemail)
//            builder.setView(view)
//            builder.setPositiveButton("Reset", DialogInterface.OnClickListener{ _, _ ->
//
//                forgotPassword(username)
//            })
//            builder.setNegativeButton("Close", DialogInterface.OnClickListener{ _, _ ->})
//            builder.show()
//        }
//---------------------------------------------------------------------------------------------//
        binding.Regis.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.BtnRegister.setOnClickListener {

            val loading = LoadingDialog(this)
            loading.startLoading()
            val handler = Handler()
            handler.postDelayed(object :Runnable{
                override fun run() {
                    loading.isDismiss()
                }

            },3000)
            //_____________progressBar______________________________________________________________________________
//            binding.progress11.visibility=View.VISIBLE
            submitForm()

        }
    }

    private fun forgotPassword(username: EditText) {
        if (username.text.toString().trim().isEmpty()){
            username.error="Please Enter Email ID"
            username.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(username.text.toString().trim()).matches()){
            return
        }
        mAuth?.sendPasswordResetEmail(username.text.toString().trim())
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this,"Email Sent", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Failed to send Email", Toast.LENGTH_SHORT).show()
                }
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
//                    binding.progress11.visibility=View.GONE

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
