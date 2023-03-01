package com.example.feelfit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.feelfit.Credentials.Login
import com.example.feelfit.GainingExercises.Exercise2
import com.example.feelfit.LosingExercise.ExerciseI
import com.example.feelfit.NormalExercise.NormalActivity
import com.example.feelfit.RoomDB.AppDatabase
import com.example.feelfit.databinding.ActivityDashboardBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Dashboard : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var builder: AlertDialog.Builder

    private lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    lateinit var InsDB: AppDatabase


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        builder=AlertDialog.Builder(this)

        drawerLayout=findViewById(R.id.drawerlayout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navigationView=findViewById<NavigationView>(R.id.navigation_id)
        setSupportActionBar(toolbar)


        setSupportActionBar(toolbar)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled=true
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        binding.buttonCalculate.setOnClickListener {
            intent = Intent(this@Dashboard, BmiCalculator::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        firebaseAuth= FirebaseAuth.getInstance()
        var user=firebaseAuth.currentUser?.email



        firebaseUser = FirebaseAuth.getInstance().currentUser!!
            binding.userMail.setText(firebaseUser.email)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("LogNotTimber")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.profile -> {

                InsDB = AppDatabase.getDatabase(applicationContext)
                GlobalScope.launch(Dispatchers.IO) {

                    val user = firebaseAuth.currentUser?.email

                    val enties = user?.let { InsDB.userInfoDao().getAll(it) }
                    Log.e("mello", "Shubh: $enties" + "")
                    launch(Dispatchers.Main) {
                        val body = enties?.get(0)?.bmi.toString()
                        Log.e("majil", "=========>:$body ")

                        if (body==null) {
                            Toast.makeText(applicationContext,"Calculate BMI",Toast.LENGTH_SHORT).show()

                        }
                        else{
                            val intent = Intent(this@Dashboard,ShowProfileAct::class.java)
                            startActivity(intent)
                        }
                    }

                }
            }

            R.id.logout ->
            {
                builder.setTitle("FeelFit")
                    .setMessage("Do You Want To Logout ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes"){dialogInterface,it ->
                        firebaseAuth.signOut()
                        intent= Intent(applicationContext, Login::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                    }
                    .setNegativeButton("No"){dialogInterface,it ->
                        dialogInterface.cancel()
                    }
                val alertDialog = builder.create()
                // Show the Alert Dialog box
                alertDialog.show()

            }
            R.id.GotoExer  ->
            {
                InsDB = AppDatabase.getDatabase(applicationContext)
                GlobalScope.launch(Dispatchers.IO) {

                    val user=firebaseAuth.currentUser?.email

                    val enties = user?.let { InsDB.userInfoDao().getAll(it) }
                    Log.e("mello", "Shubh: $enties" + "" )
                    launch(Dispatchers.Main) {
                        val body= enties?.get(0)?.body.toString()
                        Log.e("majil", "=========>:$body ")

                        if (body== "SEVERE SKINNY")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            finish()
                        }
                        if (body== "MODERATE SKINNY")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            finish()
                        }
                        if (body== "MODERATE SKINNY")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            finish()

                        }
                        if(body== "MILD THINNESS")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            finish()

                        }
                        if(body== "NORMAL")
                        {
                            startActivity(Intent(applicationContext, NormalActivity::class.java))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            finish()
                        }
                        if(body== "OVERWEIGHT")
                        {
                            startActivity(Intent(applicationContext, ExerciseI::class.java))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            finish()
                        }
                        if(body== "OBESE I")
                        {
                            startActivity(Intent(applicationContext, ExerciseI::class.java))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            finish()

                        }
                        if(body== "OBESE II")
                        {
                            startActivity(Intent(applicationContext, ExerciseI::class.java))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            finish()

                        }
                        else
                        {

                        }
                    }
                }



            }
            R.id.Share ->
            {
                val shareBody="Download FeelFit on Play Store:"
                val sharehub="FeelFit : make brain powerful"
                val shareIntent=Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,sharehub)
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareBody)
                startActivity(shareIntent)
            }
        }
       // drawerLayout.closeDrawer(GravityCompat.START)
        return true
         }

}

