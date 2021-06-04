package com.learning.tablayoutinfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.tablayoutinfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setHomeFragment()
    }

    private fun setHomeFragment() {
        val fm = supportFragmentManager
        val homeFragment = HomeFragment()
        val findFragment = fm.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (findFragment !is HomeFragment) {
            fm.beginTransaction()
                .add(
                    activityMainBinding.mainFrame.id,
                    homeFragment,
                    HomeFragment::class.java.simpleName
                )
                .commit()
        }
    }
}