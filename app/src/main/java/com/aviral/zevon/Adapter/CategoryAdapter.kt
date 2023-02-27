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
import com.bumptech.glide.Glide

class CategoryAdapter(private val categoryList: ArrayList<Categories>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_category, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.categoryName.text = categoryList[position].getCategory()

        var pos = 0

        if (position < 5) {
            pos = position
        } else if (position in 5..10) {
            pos = position - 5
        }

        when (pos) {
            0 -> {
                holder.background.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background01
                )
            }
            1 -> {
                holder.background.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background02
                )
            }
            2 -> {
                holder.background.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background03
                )
            }
            3 -> {
                holder.background.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background04
                )
            }
            4 -> {
                holder.background.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background05
                )
            }
        }


        Glide.with(holder.itemView.context)
            .load(categoryList[position].getImageURl())
            .into(holder.categoryImage)


    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var categoryName: TextView = itemView.findViewById(R.id.category_name)
        var categoryImage: ImageView = itemView.findViewById(R.id.category_image)
        var background: ConstraintLayout = itemView.findViewById(R.id.category_background)

    }

}