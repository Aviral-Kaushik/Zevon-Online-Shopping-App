package com.aviral.zevon.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aviral.zevon.Models.Categories
import com.aviral.zevon.R
import com.aviral.zevon.databinding.ActivityMainBinding
import com.aviral.zevon.databinding.LayoutBrandRecyclerViewBinding
import com.bumptech.glide.Glide

class BrandAdapter(private val brandImgUrls: ArrayList<String>) :
    RecyclerView.Adapter<BrandAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_brand_recycler_view, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when(position) {
            0 -> {
                holder.background.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background05
                )
            }
            1 -> {
                holder.background.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background03
                )
            }
            2 -> {
                holder.background.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background01
                )
            }
            3 -> {
                holder.background.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background04
                )
            }
        }

        Glide.with(holder.itemView.context)
            .load(brandImgUrls[position])
            .into(holder.brandImage)


    }

    override fun getItemCount(): Int {
        return brandImgUrls.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var brandImage: ImageView = itemView.findViewById(R.id.brand_photo)
        var background: ConstraintLayout = itemView.findViewById(R.id.brand_background)
    }

}