package com.aviral.zevon.SellerActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aviral.zevon.Activities.MainActivity
import com.aviral.zevon.Activities.ProductActivity
import com.aviral.zevon.Models.Products
import com.aviral.zevon.R
import com.aviral.zevon.databinding.ActivitySuccessfulBinding

class SuccessfulActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessfulBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessfulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product: Products = intent.getParcelableExtra(getString(R.string.product))!!

        if (intent.hasExtra(getString(R.string.product_updated))) {
            binding.productUploaded.text = getString(R.string.product_uploaded_successful)
        }

        binding.viewProduct.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("Product", product)
            startActivity(intent)
        }

        binding.back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}