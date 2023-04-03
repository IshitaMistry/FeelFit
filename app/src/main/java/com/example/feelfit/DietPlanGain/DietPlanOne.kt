package com.example.feelfit.DietPlanGain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.example.feelfit.Adapter.AdapterDiet
import com.example.feelfit.Dashboard.Dashboard
import com.example.feelfit.R
import com.google.android.material.tabs.TabLayout

class DietPlanOne : AppCompatActivity() {

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_plan_one)

        Log.e("help", "oneeeeee++++++++++: ")

        tabLayout = findViewById(R.id.tablelayout)
        viewPager = findViewById(R.id.viewpage)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Veg"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Non-Veg"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL


        val adapter = AdapterDiet(this,supportFragmentManager,tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))


        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        }
        )
    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, Dashboard::class.java))
        this.finish()

    }

}