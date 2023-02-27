package com.aviral.zevon.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aviral.zevon.Activities.ProductActivity
import com.aviral.zevon.Models.Products
import com.aviral.zevon.R
import com.bumptech.glide.Glide
import com.willy.ratingbar.ScaleRatingBar
import kotlin.random.Random

class ProductAdapter(private val productList: ArrayList<Products>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.productTitle.text = productList[position].productTitle
        holder.productPrice.text = "Rs. ${productList[position].productPrice} /-"
        holder.productRating.rating = productList[position].productAverageRating.toFloat()

        val pos = Random.nextInt(0,4)

        when (pos) {
            0 -> {
                holder.productBackground.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background01
                )
            }
            1 -> {
                holder.productBackground.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background02
                )
            }
            2 -> {
                holder.productBackground.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background03
                )
            }
            3 -> {
                holder.productBackground.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background04
                )
            }
            4 -> {
                holder.productBackground.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background05
                )
            }
        }


        Glide.with(holder.itemView.context)
            .load(productList[position].productImages?.get(0))
            .into(holder.productImage)

        holder.itemView.setOnClickListener {
            val product = productList[position]

            val intent = Intent(holder.itemView.context, ProductActivity::class.java)
            intent.putExtra("Product", product)
            holder.itemView.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val productImage: ImageView = itemView.findViewById(R.id.product_image)
        val productTitle: TextView = itemView.findViewById(R.id.product_title)
        val productRating: ScaleRatingBar = itemView.findViewById(R.id.product_rating)
        val productPrice: TextView = itemView.findViewById(R.id.product_price)
        val productBackground: ConstraintLayout = itemView.findViewById(R.id.product_background)

    }

}