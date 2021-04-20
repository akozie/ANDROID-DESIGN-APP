package com.example.uidesignandroidstudio.resources

import com.example.uidesignandroidstudio.R
import com.example.uidesignandroidstudio.model.ContributorsModel

class Contributors {
    val contributorsList = initializeContributors()

    /**
     * INITIALIZE CONTRIBUTORS  LIST
     * */
    private fun initializeContributors(): ArrayList<ContributorsModel> {
        val list = ArrayList<ContributorsModel>()

        /**
         * ADD CONTRIBUTORS TO LIST
         * */
        list.add(ContributorsModel("Olalekan", "from 5%", "clothes and shoes" , R.drawable.shopping_bag_red))
        list.add(ContributorsModel("Aviasales", "from 7%", "shirts and bags", R.drawable.shopping_bag_blue))
        list.add(ContributorsModel("James", "from 9%", "shoes", R.drawable.shopping_bag_red))
        list.add(ContributorsModel("Jole", "from 0.5%", "electronics", R.drawable.shopping_bag_blue))
        return  list
    }
}