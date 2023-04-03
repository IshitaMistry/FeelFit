package com.example.feelfit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class ActivityforDietF : Fragment() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentPageAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View?{
        val view= inflater.inflate(R.layout.activity_activityfor_diet_f, container, false)


        tabLayout = view.findViewById(R.id.trable)
        viewPager2 = view.findViewById(R.id.viewPager2)



       val adapter = fragmentManager?.let { FragmentPageAdapter(it,lifecycle) }
        tabLayout.addTab(tabLayout.newTab().setText("Veg"))
        tabLayout.addTab(tabLayout.newTab().setText("Non-Veg"))

        viewPager2.adapter = adapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }


        })
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }

        })
        return view
    }
}