package com.example.feelfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
class DietPlanOne : AppCompatActivity() {


    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_plan_one)

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
}