package com.example.feelfit.Adapter

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.feelfit.VegDietPlan
import com.example.feelfit.nonveg_diet_plan

class AdapterDiet(private val myContext: Context, fm: FragmentManager, private var totalTabs: Int): FragmentStatePagerAdapter(fm, BEHAVIOR_SET_USER_VISIBLE_HINT)

{
    override fun getItem(position: Int): Fragment {
        Log.e("help", "++++++++++: $position")

        return when (position) {
            0 -> {
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