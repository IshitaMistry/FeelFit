package com.example.feelfit

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdapterDietLose(
    private val mycontext: Context,
    fm: FragmentManager,
    private var totaltabs1: Int) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
      //  Log.e("help", "++++++++++totaltabs1:  $totaltabs1")
        return totaltabs1
    }

    override fun getItem(position: Int): Fragment {
        Log.e("help", "++++++++++position:  $position")
        return when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                VegLose()
            }
            1 -> {
                NonVegLose()
            }

            else -> {
                VegLose()
            }

        }
    }
}