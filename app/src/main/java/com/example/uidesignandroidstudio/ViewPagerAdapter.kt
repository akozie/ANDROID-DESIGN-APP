package com.example.uidesignandroidstudio

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.uidesignandroidstudio.model.DebitCardModel


class ViewPagerAdapter(private var debitCardList: ArrayList<DebitCardModel>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(){

    /**
     * RECYCLERVIEW CLASS
     * */
     class ViewPagerViewHolder(view: View) : RecyclerView.ViewHolder(view){}

    /**
     * DISPLAY ITEMS USING HOLDER
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewPagerViewHolder {
        return ViewPagerViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_pager, parent, false))
    }

    override fun getItemCount(): Int {
    return debitCardList.size
    }


    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.itemView.apply {
            /**
             * The list and data of each position and instantiate them
             * */
            val debitCard = debitCardList[position]

            /**
             * Set List data to UI views
             * */
            val debitCardName = findViewById<TextView>(R.id.debit_card_name)
            val debitCardBalance = findViewById<TextView>(R.id.debit_card_balance)
            val debitCardColor = findViewById<LinearLayout>(R.id.debit_card_color)

            debitCardName.text = debitCard.name
            debitCardBalance.text = debitCard.amount
            debitCardColor.setBackgroundResource(debitCardList[position].color)
        }

    }

}