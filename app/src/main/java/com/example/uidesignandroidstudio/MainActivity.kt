package com.example.uidesignandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.uidesignandroidstudio.fragments.*
import com.example.uidesignandroidstudio.resources.Contributors
import com.example.uidesignandroidstudio.resources.DebitCards
import com.google.android.material.bottomnavigation.BottomNavigationView
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * REMOVE THE APP BAR
         * */
        val bar = supportActionBar
        bar?.hide()

        /**
         * INSTANTIATE EACH FRAGMENTS
         * */
        val productsFragment = ProductsFragment()
        val supportFragment = SupportFragment()
        val paymentsFragment = PaymentsFragment()
        val moreFragment = MoreFragment()
        val historyFragment = HistoryFragment()

        /**
         * CALL THE CURRENTFRAGMENT METHOD
         * */
        currentFragment(productsFragment)

        /**
         * BOTTOM NAVIGATION
         * */
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_products -> currentFragment(productsFragment)
                R.id.ic_support -> currentFragment(supportFragment)
                R.id.ic_payments -> currentFragment(paymentsFragment)
                R.id.ic_more -> currentFragment(moreFragment)
                R.id.ic_history -> currentFragment(historyFragment)
            }
            true
        }
    }

    private fun currentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame, fragment)
            commit()
        }
    }


