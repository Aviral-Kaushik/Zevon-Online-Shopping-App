package com.aviral.zevon.SellerActivities

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidbuffer.kotlinfilepicker.KotConstants
import com.androidbuffer.kotlinfilepicker.KotRequest
import com.androidbuffer.kotlinfilepicker.KotResult
import com.aviral.zevon.Models.SellerForm
import com.aviral.zevon.R
import com.aviral.zevon.Utils.FirebaseMethods
import com.aviral.zevon.Utils.PermissionManager
import com.aviral.zevon.Utils.PermissionManager.Companion.checkAndVerifyPermission
import com.aviral.zevon.Utils.PermissionManager.Companion.requestPermission
import com.aviral.zevon.databinding.ActivityUploadDocumentsBinding
import com.shuhart.stepview.StepView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UploadDocumentsActivity : AppCompatActivity() {

    private val TAG = "AviralKaushik"

    private lateinit var binding: ActivityUploadDocumentsBinding

    private val AADHAR_REQUEST_CODE = 101
    private val PAN_REQUEST_CODE = 102
    private val GSTIN_REQUEST_CODE = 103

    private lateinit var aadhar: String
    private lateinit var pan: String
    private lateinit var gstin: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sellerForm = intent.getParcelableExtra<SellerForm>("Seller Form")

        setUpStemView()

        if (!checkAndVerifyPermission(PermissionManager.PERMISSIONS, this)) {
            requestPermission(PermissionManager.PERMISSIONS, this)
        }

        binding.uploadAadhar.setOnClickListener {
            initializePhotoPicker(AADHAR_REQUEST_CODE)
        }

        binding.uploadPan.setOnClickListener {
            initializePhotoPicker(PAN_REQUEST_CODE)
        }

        binding.uploadGstin.setOnClickListener {
            initializePhotoPicker(GSTIN_REQUEST_CODE)
        }

        binding.uploadDocuments.setOnClickListener {
            if (aadhar == "") {
                Toast.makeText(this, "Please Upload Aadhar", Toast.LENGTH_SHORT).show()
            } else if (pan == "") {
                Toast.makeText(this, "Please Upload PAN", Toast.LENGTH_SHORT).show()
            } else if (gstin == "") {
                Toast.makeText(this, "Please Upload GSTIN", Toast.LENGTH_SHORT).show()
            } else {

                CoroutineScope(Dispatchers.Main).launch {
                    val firebaseMethods = FirebaseMethods(this@UploadDocumentsActivity)
                    firebaseMethods.uploadDocumentsAndAddUserToDatabase(
                        aadhar,
                        pan,
                        gstin,
                        sellerForm!!
                    )
                }
            }

        }
    }

    private fun initializePhotoPicker(customCode: Int) {
        KotRequest.Gallery(this, customCode)
            .isMultiple(false)
            .pick()
    }


    private fun setUpStemView() {
        val steps = mutableListOf<String>()
        steps.add("Fill Seller Form")
        steps.add("Upload Documents")

        val stepView: StepView = findViewById(R.id.step_view)
        stepView.setSteps(steps)
        stepView.setStepsNumber(2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (AADHAR_REQUEST_CODE == requestCode && resultCode == Activity.RESULT_OK) {
            val result =
                data?.getParcelableArrayListExtra<KotResult>(KotConstants.EXTRA_FILE_RESULTS)
            aadhar = result!![0].location.toString()
        } else if (PAN_REQUEST_CODE == requestCode && resultCode == Activity.RESULT_OK) {
            val result =
                data?.getParcelableArrayListExtra<KotResult>(KotConstants.EXTRA_FILE_RESULTS)
            pan = result!![0].location.toString()
        } else if (GSTIN_REQUEST_CODE == requestCode && resultCode == Activity.RESULT_OK) {
            val result =
                data?.getParcelableArrayListExtra<KotResult>(KotConstants.EXTRA_FILE_RESULTS)
            gstin = result!![0].location.toString()
        }
    }

}