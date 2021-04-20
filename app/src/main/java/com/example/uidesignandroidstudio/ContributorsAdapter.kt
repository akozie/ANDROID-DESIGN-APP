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
            val contributors_name = findViewById<TextView>(R.id.contributors_name)
            val contributors_percentage = findViewById<TextView>(R.id.contributors_percentage)
            val contributors_brand = findViewById<TextView>(R.id.contributors_package)
            val contributors_image = findViewById<ImageView>(R.id.contributors_image)

            contributors_name.text = contributorsList[position].name
            contributors_percentage.text = contributorsList[position].percentage
            contributors_brand.text = contributorsList[position].brand
            contributors_image.setImageResource(contributorsList[position].image)
        }
    }

}