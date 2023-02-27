package com.aviral.zevon.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aviral.zevon.Models.Categories
import com.aviral.zevon.Models.Settings
import com.aviral.zevon.R

class SettingsAdapter(private val settingsList: ArrayList<Settings>, private val context: Context) :
    RecyclerView.Adapter<SettingsAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.settings_item, parent, false)

        return SettingsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SettingsAdapter.ViewHolder, position: Int) {
        holder.settingName.text = settingsList[position].getSettingsName()

        holder.settingImage.setImageDrawable(ContextCompat.getDrawable(context, settingsList[position].getImageNames()))
    }

    override fun getItemCount(): Int {
        return settingsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var settingName: TextView = itemView.findViewById(R.id.settings_item_title)
        var settingImage: ImageView = itemView.findViewById(R.id.settings_item_icon)

    }
}