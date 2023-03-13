package com.example.feelfit.Credentials
import android.content.Intent
import android.os.Bundle
import android.os.PatternMatcher
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.feelfit.Users
import com.example.feelfit.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout
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

        emailFocusListener()
        passwordFocusListener()
        firstnameListner()
        cnfFocusListner()



        binding.Login.setOnClickListener{
            intent= Intent(this, Login::class.java)
            startActivity(intent)
        }
        // validation Start from here

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnregis23.setOnClickListener{
            submitForm()

        }

    }

    private fun submitForm() {
       binding.emailcontainer.helperText=validEmail()
        binding.pass.helperText=validPassword()
        binding.nameContainer.helperText=entFirstname()
        binding.CPass.helperText=validConf()

        val validemail=binding.emailcontainer.helperText==null
        val validpass=binding.pass.helperText==null
        val validname=binding.nameContainer.helperText==null
        val validcpass=binding.CPass.helperText==null

        if (validemail && validpass && validname && validcpass ){
            val name=binding.nameRegister.text.toString()
            val email=binding.emailregister.text.toString()
            val pass =binding.passwordRegister.text.toString()
            if (name.isEmpty()){
                binding.nameContainer.setError("Enter Your Name")
            }

            else {
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        database = FirebaseDatabase.getInstance().getReference("Users")
                        val User = Users(name, email)
                        database.child(name).setValue(User).addOnCompleteListener {
                            Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show()
                        }.addOnFailureListener {
                            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

                        }
                        intent=Intent(this, Login::class.java)
                        startActivity(intent)
                    } else {

                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }

    private fun cnfFocusListner() {
        binding.cnfPasswordRegister.setOnFocusChangeListener { view, focused ->
            if (!focused){
                binding.CPass.helperText=validConf()


            }
        }
    }

    private fun validConf(): String? {

        val cnfText=binding.cnfPasswordRegister.text.toString()
        if (cnfText.length<8)
        {
            return "minimum 8 character required"
        }
        if(!cnfText.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 Upper-case Character"
        }
        if(!cnfText.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 Lower-case Character"
        }
        if(!cnfText.matches(".*[@#\$%^&+=].*".toRegex()))
        {
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }
        return null

    }

    private fun passwordFocusListener() {
        binding.passwordRegister.setOnFocusChangeListener{View,focused ->

            if (!focused){
                binding.pass.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {

        val passwordText = binding.passwordRegister.text.toString()
        if(passwordText.length < 8)
        {
            return "Minimum 8 Character Password"
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
        binding.emailregister.setOnFocusChangeListener { View, focused ->

            if (!focused) {
                binding.emailcontainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val email = binding.emailregister.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return "Invalid Email Address"
        }
        return null

    }

    private fun firstnameListner() {
        binding.nameRegister.setOnFocusChangeListener { view, focused ->
            if (!focused){
                binding.nameContainer.helperText=entFirstname()
            }
        }
    }

    private fun entFirstname(): String? {
        val firstname=binding.nameRegister.text.toString()
        if (firstname.equals("")){
            return "enter your name"
        }
        return null
    }

}