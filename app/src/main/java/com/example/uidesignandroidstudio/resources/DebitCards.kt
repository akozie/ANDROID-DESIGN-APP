package com.example.uidesignandroidstudio.resources

import com.example.uidesignandroidstudio.R
import com.example.uidesignandroidstudio.model.DebitCardModel

class DebitCards {
    open var initDebitCards = initDebitCards()

    /**
     * INITIALIZE DEBIT CARDS LIST
     * */
    private fun initDebitCards(): ArrayList<DebitCardModel> {
        val list = ArrayList<DebitCardModel>()

        /**
         * ADD DEBIT CARDS TO LIST
         * */

        list.add(DebitCardModel("Dapo", "88,546,897.00", R.color.blue))
        list.add(DebitCardModel("Darot", "28,546,897.00", R.color.red))
        list.add(DebitCardModel("James", "68,546,897.00", R.color.green))
        list.add(DebitCardModel("Jole", "28,546,897.00", R.color.black))
        list.add(DebitCardModel("Olalekan", "99,546,897.00", R.color.purple_700))
        return  list
    }
}