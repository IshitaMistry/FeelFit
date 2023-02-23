package com.example.feelfit

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.airbnb.lottie.L
import com.example.feelfit.databinding.ActivityDashboardBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Dashboard : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var builder: AlertDialog.Builder

    private lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.profile ->
            {
                val intent = Intent(this@Dashboard,ShowProfileAct::class.java)
                startActivity(intent)
            }

            R.id.logout ->
            {
                builder.setTitle("FeelFit")
                    .setMessage("Do You Want To Logout ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes"){dialogInterface,it ->
                        firebaseAuth.signOut()
                        intent= Intent(applicationContext,Login::class.java)
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


        }
       // drawerLayout.closeDrawer(GravityCompat.START)
        return true
         }

}
