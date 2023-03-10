package com.example.feelfit.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.feelfit.VegDietPlan
import com.example.feelfit.nonveg_diet_plan

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