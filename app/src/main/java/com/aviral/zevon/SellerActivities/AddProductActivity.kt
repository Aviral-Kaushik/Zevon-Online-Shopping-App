package com.aviral.zevon.SellerActivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.androidbuffer.kotlinfilepicker.KotConstants
import com.androidbuffer.kotlinfilepicker.KotRequest
import com.androidbuffer.kotlinfilepicker.KotResult
import com.aviral.zevon.Models.Products
import com.aviral.zevon.R
import com.aviral.zevon.Utils.FirebaseMethods
import com.aviral.zevon.Utils.PermissionManager
import com.aviral.zevon.Utils.PermissionManager.Companion.checkAndVerifyPermission
import com.aviral.zevon.Utils.PermissionManager.Companion.requestPermission
import com.aviral.zevon.databinding.ActivityAddProductBinding

class AddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProductBinding

    private val productCode = 101

    private var productImages: ArrayList<String> = ArrayList()

    private val firebaseMethod = FirebaseMethods(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpSpinner()

        if (!checkAndVerifyPermission(PermissionManager.PERMISSIONS, this)) {
            requestPermission(PermissionManager.PERMISSIONS, this)
        }

        if (intent.hasExtra(getString(R.string.product_update))) {
            setupViewForProductUpdate(intent.getParcelableExtra<Products>(getString(R.string.product)))
        }

        binding.btnChooseImages.setOnClickListener {
            initializePhotoPicker()
        }

        binding.btnSubmitProduct.setOnClickListener {
            if (productImages.isNotEmpty()) {
                if (binding.productTitleText.text!!.equals("")) {
                    toastForEmptyField("Product Title")
                } else if (binding.productDescriptionText.text!!.equals("")) {
                    toastForEmptyField("Product Description")
                } else if (binding.productStockText.text!!.equals("")) {
                    toastForEmptyField("Product Stock")
                } else if (binding.productPriceText.text!!.equals("")) {
                    toastForEmptyField("Product Price")
                } else if (binding.productCategory.text!!.equals(getString(R.string.select_category))) {
                    toastForEmptyField("Product Category")
                } else {

                    binding.addProductProgressbar.visibility = View.VISIBLE
                    binding.addProductPleaseWait.visibility = View.VISIBLE

                    val product = Products(
                        firebaseMethod.getCurrentUserId(),
                        firebaseMethod.generateNewProductId(),
                        binding.productTitleText.text!!.toString(),
                        binding.productPriceText.text!!.toString(),
                        productImages,
                        binding.productDescriptionText.text!!.toString(),
                        null,
                        0.0,
                        Integer.parseInt(binding.productStockText.text.toString()),
                        binding.productCategory.text.toString()
                    )

                    firebaseMethod.addNewProductToDatabaseAndStorage(product, false)
                }
            }
        }
    }

    private fun setupViewForProductUpdate(product: Products?) {

        binding.productTitleText.setText(product?.productTitle)
        binding.productDescriptionText.setText(product?.productDescription)
        binding.productCategory.setText(product?.productCategory)
        binding.productStockText.setText(product!!.productStock)
        binding.productPriceText.setText(product.productPrice)
        productImages = product.productImages!!
        binding.btnSubmitProduct.visibility = View.GONE
        binding.btnUpdateProduct.visibility = View.VISIBLE

        binding.btnChooseImages.setOnClickListener {
            initializePhotoPicker()
        }

        binding.btnUpdateProduct.setOnClickListener {
            binding.addProductProgressbar.visibility = View.VISIBLE
            binding.addProductPleaseWait.visibility = View.VISIBLE

            val productToUpdate = Products(
                product.sellerUserId,
                product.productId,
                binding.productTitleText.text!!.toString(),
                binding.productPriceText.text!!.toString(),
                productImages,
                binding.productDescriptionText.text!!.toString(),
                product.productRatings,
                product.productAverageRating,
                Integer.parseInt(binding.productStockText.text.toString()),
                binding.productCategory.text.toString()
            )

            firebaseMethod.addNewProductToDatabaseAndStorage(productToUpdate, true)

        }
    }

    private fun setUpSpinner() {
        val productCategories = resources.getStringArray(R.array.product_category)

        val arrayAdapter = ArrayAdapter(
            this,
            R.layout.snippet_layout_dropdown_item,
            productCategories
        )

        binding.productCategory.setAdapter(arrayAdapter)
    }

    private fun toastForEmptyField(message: String) {
        Toast.makeText(this, "Please enter a valid $message", Toast.LENGTH_SHORT).show()
    }

    private fun initializePhotoPicker() {

        KotRequest.Gallery(this, 101)
            .isMultiple(true)
            .pick()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (productCode == requestCode && resultCode == Activity.RESULT_OK) {

            val result =
                data?.getParcelableArrayListExtra<KotResult>(KotConstants.EXTRA_FILE_RESULTS)

            for (kot: KotResult in result!!) {
                productImages.add(kot.location.toString())
            }
        }

    }
}