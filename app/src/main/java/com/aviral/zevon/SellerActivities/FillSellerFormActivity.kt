package com.aviral.zevon.SellerActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aviral.zevon.Models.SellerForm
import com.aviral.zevon.R
import com.aviral.zevon.databinding.ActivityFillSellerFormBinding
import com.shuhart.stepview.StepView

class FillSellerFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFillSellerFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFillSellerFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {

            if (binding.sellerName.text.isEmpty() &&
                binding.sellerCompanyName.text.isEmpty() &&
                binding.sellerPhone.text.isEmpty() &&
                binding.sellerPan.text.isEmpty() &&
                binding.sellerGstin.text.isEmpty() &&
                binding.sellerAdhar.text.isEmpty()
            ) {

                Toast.makeText(this, "Please fill form completely", Toast.LENGTH_SHORT).show()

            } else {
                val sellerForm = SellerForm(
                    binding.sellerName.text.toString(),
                    binding.sellerCompanyName.text.toString(),
                    binding.sellerCountry.selectedCountryName,
                    binding.sellerPhone.text.toString(),
                    binding.sellerPan.text.toString(),
                    binding.sellerGstin.text.toString(),
                    binding.sellerAdhar.text.toString()
                )

                val intent = Intent(this, UploadDocumentsActivity::class.java)
                intent.putExtra("Seller Form", sellerForm)
                startActivity(intent)
            }


        }

        val steps = mutableListOf<String>()
        steps.add("Fill Seller Form")
        steps.add("Upload Documents")

        val stepView: StepView = findViewById(R.id.step_view)
        stepView.setSteps(steps)
    }
}