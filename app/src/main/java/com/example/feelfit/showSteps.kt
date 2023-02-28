package com.example.feelfit
import android.Manifest
import android.Manifest.permission.ACTIVITY_RECOGNITION
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.feelfit.databinding.ActivityShowStepsBinding

class showSteps : AppCompatActivity(), SensorEventListener {
    private lateinit var binding: ActivityShowStepsBinding

    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f
    private var sensorManager: SensorManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowStepsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadData()
        resetSteps()
        requestPermission()

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


    }



    fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACTIVITY_RECOGNITION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACTIVITY_RECOGNITION),
                    1
                )
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.ACTIVITY_RECOGNITION
                    )
                ) {
                    //this will pop up
                    Toast.makeText(this, "please grant permission ", Toast.LENGTH_SHORT).show()
                }
            } else {

                Toast.makeText(this, "please grant permission ", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onResume() {
        super.onResume()
        running=true
        val stepSensor: Sensor?=sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if (stepSensor==null){
            Toast.makeText(this,"No sensor Detected on this device",Toast.LENGTH_SHORT).show()
        }else{
            sensorManager?.registerListener(this,stepSensor,SensorManager.SENSOR_DELAY_UI)
//            sensorManager?.registerListener(
//                this,stepSensor,SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onSensorChanged(event:  SensorEvent?) {
        if (running){
            totalSteps=event!!.values[0]
            val currentSteps=totalSteps.toInt()-previousTotalSteps.toInt()
            binding.tvStepstaken.text=("$currentSteps")
            binding.progressCircular.apply { setProgressWithAnimation(currentSteps.toFloat()) }

        }

    }

    override fun onAccuracyChanged(sensor:  Sensor?, accuracy: Int) {

    }

    private fun resetSteps(){
        binding.tvStepstaken.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Long tap to reset Steps",Toast.LENGTH_SHORT).show()

        })
        binding.tvStepstaken.setOnLongClickListener(View.OnLongClickListener {
            previousTotalSteps = totalSteps
            binding.tvStepstaken.text=0.toString()

            saveData()
            true

        })

    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("myPrefs",Context.MODE_PRIVATE)

        val editor=sharedPreferences.edit()
        editor.putFloat("Key1",previousTotalSteps)
        //        editor.putFloat("Key1",previousTotalSteps)
        editor.apply()
    }

    private fun loadData(){
        val sharedPreferences = getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
        val savedNumber=sharedPreferences.getFloat("key1",0f)
        Log.d("MainActivity", "$savedNumber: ")
        previousTotalSteps=savedNumber

    }
}