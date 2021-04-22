package com.example.uidesignandroidstudio.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.uidesignandroidstudio.ContributorsAdapter
import com.example.uidesignandroidstudio.R
import com.example.uidesignandroidstudio.ViewPagerAdapter
import com.example.uidesignandroidstudio.model.DebitCardModel
import com.example.uidesignandroidstudio.resources.Contributors
import com.example.uidesignandroidstudio.resources.DebitCards
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import me.relex.circleindicator.CircleIndicator3


/**
 * A simple [Fragment] subclass.
 * Use the [ProductsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductsFragment : Fragment() {

    private val debitCards = DebitCards()
    private val contributors = Contributors()


    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var contributorsAdapter: ContributorsAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var indicator: TabLayout



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        viewPager = view.findViewById(R.id.view_Pager2)
        recyclerView = view.findViewById(R.id.recycler)
        indicator = view.findViewById(R.id.indicator)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loanDebits()
        contributorsView()
    }

    /**
     * Setup CARD METHODS
     * */
    private fun loanDebits() {
        /**
         * Instantiate cards
         * */
        val debitCards = debitCards.initDebitCards

        /**
         * Setup ViewpagerAdapter
         * */
        viewPagerAdapter = ViewPagerAdapter(debitCards)

        /**
         * Setup ANIMATIONS
         * */
        viewPager.apply {
            adapter = viewPagerAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 2
            setPadding(150, 0, 150, 0)
        }
        val marginPageTransformer = MarginPageTransformer(30)
        val compositionPageTransformer = CompositePageTransformer()
        compositionPageTransformer.addTransformer(marginPageTransformer)
        compositionPageTransformer.addTransformer { page, position ->
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }
        viewPager.setPageTransformer(compositionPageTransformer)


        TabLayoutMediator(indicator, viewPager) { tab, position ->
            viewPager.setCurrentItem(tab.position, true)
        }.attach()

    }


    /**
     * Setup CONTRIBUTORS METHOD
     * */

    private fun contributorsView() {
        val contributorsList = contributors.contributorsList

        layoutManager = LinearLayoutManager( context, LinearLayoutManager.HORIZONTAL, false)

         recyclerView.layoutManager = layoutManager
        contributorsAdapter = ContributorsAdapter(contributorsList)
        recyclerView.adapter = contributorsAdapter

    }
}
