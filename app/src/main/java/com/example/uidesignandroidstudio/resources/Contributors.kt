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
        list.add(ContributorsModel("Olalekan", "from 5%", "shirts" , R.color.teal_200))
        list.add(ContributorsModel("Aviasales", "from 7%", "bags", R.color.black))
        list.add(ContributorsModel("James", "from 9%", "shoes",R.color.teal_700))
        list.add(ContributorsModel("Jole", "from 0.5%", "electronics", R.color.teal_200))
        return  list
    }
}