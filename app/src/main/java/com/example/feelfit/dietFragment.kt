package com.example.feelfit

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class dietFragment : Fragment() {
    var tabLayout1: TabLayout? = null
    var viewPager1: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance =true
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_di_e_t, container, false)
        Log.e("help", "++++++++++: ")

        tabCall()
        return view

    }

    private fun tabCall() {
        tabLayout1=view?.findViewById<TabLayout>(R.id.tablelayout1)
        viewPager1 =view?.findViewById<ViewPager>(R.id.viewpage1)

        tabLayout1!!.addTab(tabLayout1!!.newTab().setText("Veg"))
        tabLayout1!!.addTab(tabLayout1!!.newTab().setText("Non-Veg"))
        tabLayout1!!.tabGravity = TabLayout.GRAVITY_FILL

//        val adapter = fragmentManager?.let {
//            AdapterDietLose(requireActivity(), it,tabLayout1!!.tabCount)
//        }
//        viewPager1!!.adapter = adapter
//
//        viewPager1!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout1))


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

    override fun onResume() {
        super.onResume()
        tabCall()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = fragmentManager?.let {
            AdapterDietLose(requireActivity(), it,tabLayout1!!.tabCount)
        }
        viewPager1!!.adapter = adapter

        viewPager1!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout1))

    }
}

