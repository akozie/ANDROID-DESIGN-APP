package com.example.uidesignandroidstudio

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uidesignandroidstudio.model.ContributorsModel

class ContributorsAdapter(var contributorsList: ArrayList<ContributorsModel>) :
    RecyclerView.Adapter<ContributorsAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.last_layout, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return contributorsList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.itemView.apply {
            val contributorsName = findViewById<TextView>(R.id.contributors_name)
            val contributorsPercentage = findViewById<TextView>(R.id.contributors_percentage)
            val contributorsBrand = findViewById<TextView>(R.id.contributors_package)
            val contributorsImage = findViewById<ImageView>(R.id.contributors_image)

            contributorsName.text = contributorsList[position].name
            contributorsPercentage.text = contributorsList[position].percentage
            contributorsBrand.text = contributorsList[position].brand
            contributorsImage.setImageResource(contributorsList[position].image)
        }
    }

}