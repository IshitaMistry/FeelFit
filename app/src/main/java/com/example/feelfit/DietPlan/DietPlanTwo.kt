package com.example.feelfit.DietPlan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.feelfit.AdapterDietLose
import com.example.feelfit.R
import com.google.android.material.tabs.TabLayout

class DietPlanTwo : Fragment() {

    var tabLayout1: TabLayout? = null
    var viewPager1: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance =true

    }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

        ): View? {
            val view= inflater.inflate(R.layout.activity_diet_plan_two, container, false)
            Log.e("help", "++++++++++DietPlanTwo:")

//            tabLayout1 = findViewById(R.id.tablelayout1)
//            viewPager1 = findViewById(R.id.viewpage1)

            tabLayout1=view.findViewById<TabLayout>(R.id.tablelayout1)
            viewPager1 =view.findViewById<ViewPager>(R.id.viewpage1)

            tabLayout1!!.addTab(tabLayout1!!.newTab().setText("Veg"))
            tabLayout1!!.addTab(tabLayout1!!.newTab().setText("Non-Veg"))
            tabLayout1!!.tabGravity = TabLayout.GRAVITY_FILL


           viewPager1!!.offscreenPageLimit=1
            viewPager1!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout1))

            Log.e("Mouse", "================>: $viewPager1", )


            //viewPager1!!.currentItem = 0

            tabLayout1!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager1!!.currentItem = tab.position

                }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

            return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = fragmentManager?.let {
            Log.e("help", "++++++++++adapter:  $it")
            AdapterDietLose(requireActivity(), it,tabLayout1!!.tabCount)
        }
        viewPager1!!.adapter = adapter
    }

}
