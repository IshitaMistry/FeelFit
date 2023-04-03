package com.example.feelfit.Credentials
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.feelfit.OtpActivity
import com.example.feelfit.R
import com.example.feelfit.Users
import com.example.feelfit.databinding.ActivityMainBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database:DatabaseReference
    private lateinit var sendOTPBtn: Button
    private lateinit var et_phone_number: EditText
    private lateinit var number: String
    private lateinit var mProgressBar: ProgressBar
    // string for storing our verification ID
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        sendOTPBtn.setOnClickListener {

            number = et_phone_number.text.trim().toString()
            if (number.isNotEmpty()){
                if (number.length == 10){
                    number = "+91$number"
                    mProgressBar.visibility = View.VISIBLE

                    val options = PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber(number)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
                        .build()
                    PhoneAuthProvider.verifyPhoneNumber(options)

                }else
                {
                    Toast.makeText(this,"Please Enter Correct Number",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(this,"Please Enter Number",Toast.LENGTH_SHORT).show()

            }
        }


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
    private fun init(){

        mProgressBar = findViewById(R.id.phoneProgressBar)
        mProgressBar.visibility = View.INVISIBLE
        sendOTPBtn = findViewById(R.id.sendOTPBtn)
        et_phone_number = findViewById(R.id.et_phone_number)
        firebaseAuth = FirebaseAuth.getInstance()

    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Authenticate Successfully!!",Toast.LENGTH_SHORT).show()
                    sendToMain()

                } else {
                    // Sign in failed, display a message and update the UI
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }


    private fun sendToMain() {
        startActivity(Intent(this,Login::class.java))
    }
    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            // This callback will be invoked in two situations:
            // 1 - Instant verification. In some cases the phone number can be instantly
            //     verified without needing to send or enter a verification code.
            // 2 - Auto-retrieval. On some devices Google Play services can automatically
            //     detect the incoming verification SMS and perform verification without
            //     user action.
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.

            if (e is FirebaseAuthInvalidCredentialsException) {
                // Invalid request
            } else if (e is FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
            }

            // Show a message and update the UI
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            // The SMS verification code has been sent to the provided phone number, we
            // now need to ask the user to enter the code and then construct a credential
            // by combining the code with a verification ID.


            val intent = Intent(this@MainActivity,OtpActivity::class.java)
            intent.putExtra("OTP",verificationId)
            intent.putExtra("resendToken",token)
            intent.putExtra("phoneNumber",number)
            startActivity(intent)
            mProgressBar.visibility = View.INVISIBLE
            // Save verification ID and resending token so we can use them later
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

                        var uid=firebaseAuth?.uid
                        database = FirebaseDatabase.getInstance().getReference("Users")
                        val User = Users(name, email,"","","","","","",)
                        if (uid != null) {
                            database.child(uid).setValue(User).addOnCompleteListener {
                                Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show()
                            }.addOnFailureListener {
                                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

                            }
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

        val cnfText=binding.cnfPasswordRegister.text.toString().trim()
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

        val passwordText = binding.passwordRegister.text.toString().trim()
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
        val email = binding.emailregister.text.toString().trim()
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
        val firstname=binding.nameRegister.text.toString().trim()
        if (firstname.equals("")){
            return "enter your name"
        }
        return null
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null){
            startActivity(Intent(this, Login::class.java))
        }
    }

}





