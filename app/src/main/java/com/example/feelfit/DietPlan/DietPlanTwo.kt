package com.example.feelfit.DietPlan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.feelfit.Adapter.AdapterDiet
import com.example.feelfit.AdapterDietLose
import com.example.feelfit.Dashboard.Dashboard
import com.example.feelfit.R
import com.google.android.material.tabs.TabLayout

class DietPlanTwo : AppCompatActivity() {

    var tabLayout1: TabLayout? = null
    var viewPager1: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_plan_two)

        tabLayout1 = findViewById(R.id.tablelayout1)
        viewPager1 = findViewById(R.id.viewpage1)

        tabLayout1!!.addTab(tabLayout1!!.newTab().setText("Veg"))
        tabLayout1!!.addTab(tabLayout1!!.newTab().setText("Non-Veg"))
        tabLayout1!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = AdapterDietLose(this,supportFragmentManager,tabLayout1!!.tabCount)
        viewPager1!!.adapter = adapter

        viewPager1!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout1))


        tabLayout1!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager1!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })


    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(applicationContext, Dashboard::class.java))
        intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK)
        this.finish()
    }
}
