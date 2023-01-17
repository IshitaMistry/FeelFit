package com.example.feelfit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.feelfit.databinding.ActivityDashBoardBinding
import com.example.feelfit.databinding.ActivityLoginffBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth


class DashBoard : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    var num=0;

    private lateinit var binding: ActivityDashBoardBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    private lateinit var builder:AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout=findViewById(R.id.drawerlayout_id)
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        val navigationView=findViewById<NavigationView>(R.id.navigation_id)
        setSupportActionBar(toolbar)

        firebaseAuth= FirebaseAuth.getInstance()
        builder=AlertDialog.Builder(this)


//




        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled=true
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)




        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayUseLogoEnabled(true)


        binding.btn.setOnClickListener {
            intent = Intent(this,BmiCalculator::class.java)
            startActivity(intent)

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.e("parthi","===========>>>$item")
        when(item.itemId){
            R.id.profile ->
            {
                startActivity(Intent(this,ShowProfileAct::class.java))
            }
            R.id.logout ->
            {
                builder.setTitle("FeelFit")
                    .setMessage("Do You Want To Logout ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes"){dialogInterface,it ->
                        firebaseAuth.signOut()
                        intent= Intent(applicationContext,LoginActivityFF::class.java)
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
        return true

    }


}