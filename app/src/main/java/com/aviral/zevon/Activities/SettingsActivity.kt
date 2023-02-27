package com.aviral.zevon.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aviral.zevon.Adapter.CategoryAdapter
import com.aviral.zevon.Adapter.SettingsAdapter
import com.aviral.zevon.Models.Categories
import com.aviral.zevon.Models.Settings
import com.aviral.zevon.R
import com.aviral.zevon.Utils.RecyclerViewMargin
import com.aviral.zevon.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setupSettingsAdapter()
    }

    // 1.) Terms and Condition
    // 2.) Privacy Policy
    // 3.) Log out
    // 4.) Developer Page
    // 5.) Become a Seller
    // 6.) Profile Settings
    // 7.) Contact Us

//    private fun setupSettingsAdapter() {
//        var settingList = mutableListOf<Settings>()
//
//        val linearLayoutManager = LinearLayoutManager(
//            this,
//            LinearLayoutManager.VERTICAL, false
//        )

//        binding.settingsRecyclerView.layoutManager = linearLayoutManager
//
//        val recyclerViewMargin = RecyclerViewMargin(12)
//        binding.settingsRecyclerView.addItemDecoration(recyclerViewMargin)
//
//        binding.settingsRecyclerView.adapter =
//            SettingsAdapter(settingList as ArrayList<Settings>, this)

//    }
}