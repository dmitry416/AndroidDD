package com.example.androiddd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ActivityFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_activity, container, false)
        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)
        val viewPager: ViewPager2 = view.findViewById(R.id.view_pager)
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = when (position) {
                0 -> "Моя"
                1 -> "Пользователей"
                else -> null
            }
        }.attach()

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ActivityFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}