package com.example.androiddd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androiddd.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var curFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                val activityFragment = ActivityFragment.newInstance()
                add(R.id.fragment_container, activityFragment, "ActivityFragment")
                curFragment = activityFragment
                commit()
            }
        }
        else {
            curFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        }

        binding.bottomNavigation.setOnItemSelectedListener  { item ->
            when (item.itemId) {
                R.id.nav_activity -> {
                    switchPage("ActivityFragment") { ActivityFragment.newInstance() }
                    true
                }

                R.id.nav_profile -> {
                    switchPage("ProfileFragment") { ProfileFragment.newInstance() }
                    true
                }

                else -> false
            }

        }
    }

    private fun switchPage(tag: String, fragmentCreator: () -> Fragment) {
        val targetFragment = supportFragmentManager.findFragmentByTag(tag)

        supportFragmentManager.beginTransaction().apply {
            if (curFragment != null)
                hide(curFragment!!)
            if (targetFragment == null) {
                val newFragment = fragmentCreator()
                add(R.id.fragment_container, newFragment, tag)
                curFragment = newFragment
            }
            else {
                show(targetFragment)
                curFragment = targetFragment
            }
            commit()
        }
    }
}