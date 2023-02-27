package com.aviral.zevon.SellerActivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.aviral.zevon.R
import com.aviral.zevon.Utils.FirebaseAuthProvider
import com.aviral.zevon.databinding.ActivitySellerPanelBinding

class SellerPanelActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySellerPanelBinding

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(
            this, R.anim.rotate_open_anim
        )
    }

    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(
            this, R.anim.rotate_close_anim
        )
    }

    private val sellerProductAnim: Animation by lazy { AnimationUtils.loadAnimation(
            this, R.anim.seller_product_view_anim
        )
    }

    private val sellerAddAnim: Animation by lazy { AnimationUtils.loadAnimation(
        this, R.anim.seller_add_product_anim
    )
    }

    private val sellerLogoutAnim: Animation by lazy { AnimationUtils.loadAnimation(
        this, R.anim.seller_logout_anim
    )
    }

    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(
            this, R.anim.to_bottom_anim
        )
    }

    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerPanelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sellerOptions.setOnClickListener {
            onSellerOptionPressed()
        }

        binding.sellerCreateProduct.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
            finish()
        }

        binding.sellerLogOut.setOnClickListener {
            val firebaseAuthProvider = FirebaseAuthProvider(this)
            firebaseAuthProvider.signOutUser()
            finish()
        }

    }

    private fun onSellerOptionPressed() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)

        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding.sellerViewProducts.visibility = View.VISIBLE
            binding.sellerCreateProduct.visibility = View.VISIBLE
            binding.sellerLogOut.visibility = View.VISIBLE
        } else {
            binding.sellerViewProducts.visibility = View.INVISIBLE
            binding.sellerCreateProduct.visibility = View.INVISIBLE
            binding.sellerLogOut.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            binding.sellerViewProducts.startAnimation(sellerProductAnim)
            binding.sellerCreateProduct.startAnimation(sellerAddAnim)
            binding.sellerLogOut.startAnimation(sellerLogoutAnim)
            binding.sellerOptions.startAnimation(rotateOpen)
        } else {
            binding.sellerViewProducts.startAnimation(toBottom)
            binding.sellerCreateProduct.startAnimation(toBottom)
            binding.sellerLogOut.startAnimation(toBottom)
            binding.sellerOptions.startAnimation(rotateClose)
        }
    }

    private fun setClickable(clicked: Boolean) {
        if (!clicked) {
            binding.sellerViewProducts.isClickable = true
            binding.sellerCreateProduct.isClickable = true
            binding.sellerLogOut.isClickable = true
            binding.sellerViewProducts.isFocusable = true
            binding.sellerCreateProduct.isFocusable = true
            binding.sellerLogOut.isFocusable = true
        } else {
            binding.sellerViewProducts.isClickable = false
            binding.sellerCreateProduct.isClickable = false
            binding.sellerLogOut.isClickable = false
            binding.sellerViewProducts.isFocusable = false
            binding.sellerCreateProduct.isFocusable = false
            binding.sellerLogOut.isFocusable = false
        }
    }

}