package com.example.feelfit

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NotificationCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.example.feelfit.Credentials.Login
import com.example.feelfit.GainingExercises.Exercise2
import com.example.feelfit.LosingExercise.ExerciseI
import com.example.feelfit.NormalExercise.NormalActivity
import com.example.feelfit.RoomDB.AppDatabase
import com.example.feelfit.databinding.ActivityDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class Dashboard : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var builder: AlertDialog.Builder

    private lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout




    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //--------------Main Fragments-------------------------//
        val btn = findViewById<BottomNavigationItemView>(R.id.profile)
        btn.setOnClickListener {
            val intent = Intent(applicationContext,ShowProfileAct::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            val FragmentManager= supportFragmentManager
            val FragmentTransaction=FragmentManager.beginTransaction()
            FragmentTransaction.replace(R.id.fragment,home())
            FragmentTransaction.commit()

        }

        val btn2 = findViewById<BottomNavigationItemView>(R.id.exercise)
        btn2.setOnClickListener {
            InsDB = AppDatabase.getDatabase(applicationContext)
            GlobalScope.launch(Dispatchers.IO) {

                var user=firebaseAuth.currentUser?.email

                var enties = user?.let { InsDB.userInfoDao().getAll(it) }
                Log.e("mello", "Shubh: $enties" + "" )
                launch(Dispatchers.Main) {
                    var body= enties?.get(0)?.body.toString()
                    Log.e("majil", "=========>:$body ")

                    if (body== "SEVERE SKINNY")
                    {
                        startActivity(Intent(applicationContext, Exercise2::class.java))
                        finish()
                    }
                    if (body== "MODERATE SKINNY")
                    {
                        startActivity(Intent(applicationContext, Exercise2::class.java))
                        finish()
                    }
                    if (body== "MODERATE SKINNY")
                    {
                        startActivity(Intent(applicationContext, Exercise2::class.java))
                        finish()

                    }
                    if(body== "MILD THINNESS")
                    {
                        startActivity(Intent(applicationContext, Exercise2::class.java))
                        finish()

                    }
                    if(body== "NORMAL")
                    {
                        startActivity(Intent(applicationContext, NormalActivity::class.java))
                        finish()
                    }
                    if(body== "OVERWEIGHT")
                    {
                        startActivity(Intent(applicationContext, ExerciseI::class.java))
                        finish()
                    }
                    if(body== "OBESE I")
                    {
                        startActivity(Intent(applicationContext, ExerciseI::class.java))
                        finish()
                    }
                    if(body== "OBESE II")
                    {
                        startActivity(Intent(applicationContext, ExerciseI::class.java))
                        finish()

                    }
                    else
                    {

                    }
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }

            val FragmentManager= supportFragmentManager
            val FragmentTransaction=FragmentManager.beginTransaction()
            FragmentTransaction.replace(R.id.fragment,home())
            FragmentTransaction.commit()

        }





      //  startActivity(Intent(applicationContext,Reminder::class.java))

        //-------------------------------------------------------------------------------------




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

        // notification for water
//--------------------------------------______________________________________________________
       var intent = Intent(this, water::class.java)
        val pendingIntent: PendingIntent
        pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        } else {
            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis(),
            REMINDER_INTERVAL_MILLIS.toLong(),
            pendingIntent
        )

//_______________________________________________//____________________________________________________//______________
//____________________________________________//____________________________________________________________________//______

        navigationView.setNavigationItemSelectedListener(this)
        navigationView.bringToFront()
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        binding.buttonCalculate.setOnClickListener {
            intent = Intent(this@Dashboard, BmiCalculator::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }

        firebaseAuth= FirebaseAuth.getInstance()
        var user=firebaseAuth.currentUser?.email



        firebaseUser = FirebaseAuth.getInstance().currentUser!!
            binding.userMail.setText(firebaseUser.email)
    }

    companion object {
        private const val REMINDER_INTERVAL_MILLIS = 60 * 60 * 1000
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    lateinit var InsDB: AppDatabase

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        Log.e("majil", "=========>:$item ")
        when(item.itemId)
        {
            R.id.profile ->
            {
                val intent = Intent(this@Dashboard,ShowProfileAct::class.java)
                startActivity(intent)
                this.finish()
            }

            R.id.logout ->
            {
                builder.setTitle("FeelFit")
                    .setMessage("Do You Want To Logout ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes"){dialogInterface,it ->
                        firebaseAuth.signOut()
                        intent= Intent(applicationContext, Login::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent)
                        this.finish()
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

                    var user=firebaseAuth.currentUser?.email

                    var enties = user?.let { InsDB.userInfoDao().getAll(it) }
                    Log.e("mello", "Shubh: $enties" + "" )
                    launch(Dispatchers.Main) {
                        var body= enties?.get(0)?.body.toString()
                        Log.e("majil", "=========>:$body ")

                        if (body== "SEVERE SKINNY")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))
                            finish()
                        }
                        if (body== "MODERATE SKINNY")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))
                            finish()
                        }
                        if (body== "MODERATE SKINNY")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))
                            finish()

                        }
                        if(body== "MILD THINNESS")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))
                            finish()

                        }
                        if(body== "NORMAL")
                        {
                            startActivity(Intent(applicationContext, NormalActivity::class.java))
                            finish()
                        }
                        if(body== "OVERWEIGHT")
                        {
                            startActivity(Intent(applicationContext, ExerciseI::class.java))
                            finish()
                        }
                        if(body== "OBESE I")
                        {
                            startActivity(Intent(applicationContext, ExerciseI::class.java))
                            finish()
                        }
                        if(body== "OBESE II")
                        {
                            startActivity(Intent(applicationContext, ExerciseI::class.java))
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
    override fun onBackPressed() {
        super.onBackPressed()
        builder.setTitle("FeelFit")
            .setMessage("Do You Want To Logout ?")
            .setCancelable(false)
            .setPositiveButton("Yes"){dialogInterface,it ->
                firebaseAuth.signOut()
                intent= Intent(applicationContext, Login::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent)
                this.finish()
            }
            .setNegativeButton("No"){dialogInterface,it ->
                dialogInterface.cancel()
            }
       // val alertDialog = builder.create()
        // Show the Alert Dialog box
        //alertDialog.show()

    }

}

