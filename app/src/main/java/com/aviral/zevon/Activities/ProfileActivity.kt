package com.aviral.zevon.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.aviral.zevon.Adapter.ProductAdapter
import com.aviral.zevon.Models.Products
import com.aviral.zevon.Models.Rating
import com.aviral.zevon.R
import com.aviral.zevon.SellerActivities.BecomeSellerActivity
import com.aviral.zevon.SellerActivities.SellerPanelActivity
import com.aviral.zevon.SellerActivities.SuccessfulActivity
import com.aviral.zevon.Utils.FirebaseMethods
import com.aviral.zevon.Utils.RecyclerViewMargin
import com.aviral.zevon.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.coroutines.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    private val baseUrl: String = "https://zevon.onrender.com/"

    private lateinit var mAuth: FirebaseAuth
    private lateinit var myRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileScrollView.fullScroll(ScrollView.FOCUS_UP)

        setupFirebase()

        isSeller()

        binding.settingsAnimation.bringToFront()

        binding.btnBecomeSeller.setOnClickListener {

            if (mAuth.currentUser != null) {
                startActivity(Intent(this, BecomeSellerActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }

        }

        binding.btnSellerPanel.setOnClickListener {
            startActivity(Intent(this, SellerPanelActivity::class.java))
            finish()
        }

        binding.btnYourOrders.setOnClickListener {

            val imageProduct5 = mutableListOf<String>()
            imageProduct5.add("$baseUrl/images/products/6369e8fd9637e9b6d8e1c154.jpg")

            val ratingsProduct1 = mutableListOf<Rating>()
            ratingsProduct1.add(Rating("aviral_3101", 3.5, "Average Products"))
            ratingsProduct1.add(Rating("avichal1106", 5.toDouble(), "Nice Product I like it"))
            ratingsProduct1.add(Rating("anil1001", 5.toDouble(), "Nice Product I like it"))
            ratingsProduct1.add(Rating("pallavi1012", 4.toDouble(), "Nice Product I like it"))

            val products = Products("1",
                "1",
                "Nivia brand 1019 Football, Youth Size 5 football for all ages includes vaccum pump",
                "650",
                imageProduct5 as ArrayList<String> /* = java.util.ArrayList<kotlin.String> */,
                "Included Components: Football With Pump, Size Name: 5, Color Map: Multicolour Special Feature: Water Resistant Age Range Description: All Age Groups, Material Type: PU Skill Level: Recreational, Target Audience Base: Adults, Construction Type: Hand Stitched",
                ratingsProduct1 as ArrayList<Rating> /* = java.util.ArrayList<com.aviral.zevon.Models.Rating> */,
                3.5,
                50,
                "Sports"
             )

            val intent = Intent(this, SuccessfulActivity::class.java)
            intent.putExtra(getString(R.string.product), products)
            startActivity(intent)
            finish()

        }

        setupProfileAdapter()
        setupBottomNavigation()

    }

    private fun setupFirebase() {

        mAuth = FirebaseAuth.getInstance()

        val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance("https://zevon-3cd72-default-rtdb.asia-southeast1.firebasedatabase.app")
        myRef = firebaseDatabase.reference
    }

    private fun isSeller() {

        CoroutineScope(Dispatchers.Default).launch {
            binding.profileProgressBar.visibility = View.VISIBLE

            if (mAuth.currentUser != null) {
                val query = myRef.child(getString(R.string.sellers))
                    .orderByChild("sellerId")
                    .equalTo(mAuth.currentUser!!.uid)
                    .limitToFirst(1)

                query.addListenerForSingleValueEvent(object: ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {

                        if (snapshot.exists()) {

                            binding.btnSellerPanel.visibility = View.VISIBLE
                            binding.btnBecomeSeller.visibility = View.GONE

                        }

                        binding.profileProgressBar.visibility = View.GONE

                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("AviralKaushik", "onCancelled: Error under isSeller: ${error.message}")

                        binding.profileProgressBar.visibility = View.GONE
                    }

                })
            } else {
                binding.profileProgressBar.visibility = View.GONE
            }
        }

        binding.profileProgressBar.visibility = View.GONE
    }

    private fun setupBottomNavigation() {

        val homeLayout: LinearLayout = findViewById(R.id.btnHome)
        val profileLayout: LinearLayout = findViewById(R.id.btnProfile)
        val contactLayout: LinearLayout = findViewById(R.id.btnContact)
        val settingsLayout: LinearLayout = findViewById(R.id.btnSettings)

        homeLayout.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
        contactLayout.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    DeveloperProfileActivity::class.java
                )
            )
        }
        settingsLayout.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }


        homeLayout.background = ContextCompat.getDrawable(
            this,
            R.drawable.background_white
        )

        profileLayout.background = ContextCompat.getDrawable(
            this,
            R.drawable.bottom_navigation_background
        )

        contactLayout.background = ContextCompat.getDrawable(
            this,
            R.drawable.background_white
        )

        settingsLayout.background = ContextCompat.getDrawable(
            this,
            R.drawable.background_white
        )
    }


    private fun setupProfileAdapter() {

    }
}