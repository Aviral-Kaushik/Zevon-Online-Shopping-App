package com.aviral.zevon.SellerActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aviral.zevon.R
import com.aviral.zevon.databinding.ActivityBecomeSellerBinding

class BecomeSellerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBecomeSellerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBecomeSellerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.becomeSeller.setOnClickListener {

            if(binding.sellerAgreementCheckBox.isChecked
                && binding.termsConditionCheckBox.isChecked) {

                startActivity(Intent(this, FillSellerFormActivity::class.java))
                finish()

            }
            else {

                Toast.makeText(this, "Please accept Terms and Condition and Seller Agreement", Toast.LENGTH_SHORT).show()

            }
        }
    }
}