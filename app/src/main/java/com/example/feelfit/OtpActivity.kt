package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.chaos.view.PinView
import com.example.feelfit.Dashboard.Dashboard
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class OtpActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    private lateinit var verifyBtn: Button
    private lateinit var resendTV: TextView
    private lateinit var firstPinView: PinView

    private lateinit var OTP: String
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var phoneNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        OTP = intent.getStringExtra("OTP").toString()
        resendToken = intent.getParcelableExtra("resendToken")!!
        phoneNumber = intent.getStringExtra("phoneNumber")!!

        init()
        addTextChangeListener()
        resendOTPTvVisibility()

        resendTV.setOnClickListener {
            resendVerificationCode()
            resendOTPTvVisibility()
        }

        findViewById<TextView>(R.id.resendTV)
        findViewById<Button>(R.id.verifyBtn)
        findViewById<PinView>(R.id.firstPinView)
        verifyBtn.setOnClickListener {
            //collect otp from all the edit texts
            val typedOTP = firstPinView
            if (typedOTP.isEnabled) {
                if (typedOTP.length() == 6) {
                    val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(
                        OTP, typedOTP.text.toString()
                    )
                    signInWithPhoneAuthCredential(credential)
                } else {
                    Toast.makeText(this, "Please Enter Correct OTP", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please Enter OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun resendOTPTvVisibility() {
        firstPinView.setText("")
        resendTV.visibility = View.INVISIBLE
        resendTV.isEnabled = false

        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            resendTV.visibility = View.VISIBLE
            resendTV.isEnabled = true
        }, 20000)
    }

    private fun resendVerificationCode() {
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callbacks)
            .setForceResendingToken(resendToken)// OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
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
                Log.d("TAG", "onVerificationFailed: ${e.toString()}")
            } else if (e is FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
                Log.d("TAG", "onVerificationFailed: ${e.toString()}")
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
            // Save verification ID and resending token so we can use them later
            OTP = verificationId
            resendToken = token
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    Toast.makeText(this, "Authenticate Successfully", Toast.LENGTH_SHORT).show()
                    sendToMain()
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.d("TAG", "signInWithPhoneAuthCredential: ${task.exception.toString()}")
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }

    private fun sendToMain() {
        startActivity(Intent(this, Dashboard::class.java))
        finish()
    }

    private fun addTextChangeListener() {
        firstPinView.addTextChangedListener(EditTextWatcher(firstPinView))
//        inputOTP1.addTextChangedListener(EditTextWatcher(inputOTP1))
//        inputOTP2.addTextChangedListener(EditTextWatcher(inputOTP2))
//        inputOTP3.addTextChangedListener(EditTextWatcher(inputOTP3))
//        inputOTP4.addTextChangedListener(EditTextWatcher(inputOTP4))
//        inputOTP5.addTextChangedListener(EditTextWatcher(inputOTP5))
//        inputOTP6.addTextChangedListener(EditTextWatcher(inputOTP6))
    }

    private fun init() {
        firebaseAuth = FirebaseAuth.getInstance()
        verifyBtn = findViewById(R.id.verifyBtn)
        resendTV = findViewById(R.id.resendTV)
        firstPinView = findViewById(R.id.firstPinView)
//        inputOTP1 = findViewById(R.id.otpEditText1)
//        inputOTP2 = findViewById(R.id.otpEditText2)
//        inputOTP3 = findViewById(R.id.otpEditText3)
//        inputOTP4 = findViewById(R.id.otpEditText4)
//        inputOTP5 = findViewById(R.id.otpEditText5)
//        inputOTP6 = findViewById(R.id.otpEditText6)
    }


    inner class EditTextWatcher(private val view: View) : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {

            val text = p0.toString()
            when (view.id) {
                R.id.firstPinView -> if (text.length == 1) firstPinView.requestFocus()
//                R.id.otpEditText1 -> if (text.length == 1) inputOTP2.requestFocus()
//                R.id.otpEditText2 -> if (text.length == 1) inputOTP3.requestFocus() else if (text.isEmpty()) inputOTP1.requestFocus()
//                R.id.otpEditText3 -> if (text.length == 1) inputOTP4.requestFocus() else if (text.isEmpty()) inputOTP2.requestFocus()
//                R.id.otpEditText4 -> if (text.length == 1) inputOTP5.requestFocus() else if (text.isEmpty()) inputOTP3.requestFocus()
//                R.id.otpEditText5 -> if (text.length == 1) inputOTP6.requestFocus() else if (text.isEmpty()) inputOTP4.requestFocus()
//                R.id.otpEditText6 -> if (text.isEmpty()) inputOTP5.requestFocus()

            }
        }



    }




}