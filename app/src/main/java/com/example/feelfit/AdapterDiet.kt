package com.example.feelfit

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdapterDiet(private val myContext: Context, fm: FragmentManager, private var totalTabs: Int): FragmentPagerAdapter(fm)

{


    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                VegDietPlan()
            }
            1 -> {
                nonveg_diet_plan()
            }

            else -> {
                VegDietPlan()
            }

        }
    }
    override fun getCount(): Int {

        return totalTabs
    }


}