package com.aviral.zevon.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aviral.zevon.Adapter.ProductAdapter
import com.aviral.zevon.Models.Products
import com.aviral.zevon.Models.Rating
import com.aviral.zevon.Utils.RecyclerViewMargin
import com.aviral.zevon.databinding.ActivityProductBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding

    private lateinit var product: Products

    private val baseUrl: String = "https://zevon.onrender.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        product = intent.getParcelableExtra("Product")!!

        setupCarousel()
        setupWidgets()
        setupProductAdapter()
    }

    private fun setupWidgets() {

        var currentProductQuantity:Int = binding.productQuantity.text.toString().toInt()

        binding.itemName.text = product.productTitle
        binding.itemDescription.text = product.productDescription
        binding.productPrice.text = product.productPrice
        binding.productRating.rating = product.productAverageRating.toFloat()
        binding.totalReviews.text = "${product.productRatings?.size} reviews"

        binding.btnBuyNow.setOnClickListener {
            Toast.makeText(this, "Buying", Toast.LENGTH_SHORT).show()
        }

        binding.btnAddToCart.setOnClickListener {
            Toast.makeText(this, "Added To Cart", Toast.LENGTH_SHORT).show()
        }

        binding.seeAllReviews.setOnClickListener {
            Toast.makeText(this, "Navigating to reviews activity", Toast.LENGTH_SHORT).show()
        }

        binding.productQuantityIncrement.setOnClickListener {
            binding.productQuantity.text = (currentProductQuantity++).toString()
        }

        binding.productQuantityDecrement.setOnClickListener {
            if (currentProductQuantity != 1) {
                binding.productQuantity.text = (currentProductQuantity--).toString()
            }
        }
    }

    private fun setupCarousel() {
        val list = mutableListOf<CarouselItem>()

        product.productImages?.forEach {
            list.add(CarouselItem(it))
        }

        binding.productCarousel.setData(list)
    }

    private fun setupProductAdapter() {
//        val imageProduct1 = mutableListOf<String>()
//        imageProduct1.add("$baseUrl/images/products/6369345b7bedd603de119ad00.jpg")
//        imageProduct1.add("$baseUrl/images/products/6369345b7bedd603de119ad01.jpg")
//
//        val ratingsProduct1 = mutableListOf<Rating>()
//        ratingsProduct1.add(Rating("aviral_3101", 3.5, "Average Products"))
//        ratingsProduct1.add(Rating("avichal1106", 5.toDouble(), "Nice Product I like it"))
//        ratingsProduct1.add(Rating("anil1001", 5.toDouble(), "Nice Product I like it"))
//        ratingsProduct1.add(Rating("pallavi1012", 4.toDouble(), "Nice Product I like it"))
//
//        val product1 = Products("1",
//            "Adidas T-shirt made of cotton and good looking and stylish and modern looking stylish t-shirts",
//            "475",
//            imageProduct1 as ArrayList<String>,
//            "This product is the original product of Adidas. This t-shirt is very stylish and designed on seeing the keeping in mind about the modern looks and is highly fashionable.",
//            ratingsProduct1 as ArrayList<Rating>,
//            4.5
//        )
//
//        val imageProduct2 = mutableListOf<String>()
//        imageProduct2.add("$baseUrl/images/products/636933017bedd603de119ac70.jpg")
//        imageProduct2.add("$baseUrl/images/products/636933017bedd603de119ac71.jpg")
//        imageProduct2.add("$baseUrl/images/products/636933017bedd603de119ac72.webp")
//
//        val product2 = Products("1",
//            "Apple Macbook with i5 processor with heavy task handling and with 8gb ram and battery backup upto 8 hours and non-hackable laptop",
//            "123000",
//            imageProduct2 as ArrayList<String> /* = java.util.ArrayList<kotlin.String> */,
//            "This laptop is sold under the brand of Apple Inc. and is a quality product of Apple Company. This laptop is known for its great task handling and extended support. This laptop is very secured with least security issues.",
//            ratingsProduct1 /* = java.util.ArrayList<com.aviral.zevon.Models.Rating> */,
//            4.9
//        )
//
//        val imageProduct3 = mutableListOf<String>()
//        imageProduct3.add("$baseUrl/images/products/6369302a7bedd603de119aa20.jpg")
//
//        val product3 = Products("1",
//            "Dell Inspiron laptop with i5 processor with heavy task handling and with 8gb ram and battery backup upto 8 hours.",
//            "58000",
//            imageProduct3 as ArrayList<String> /* = java.util.ArrayList<kotlin.String> */,
//            "This laptop is sold under the brand of dell inc. This laptop is very good for development purpose, gaming, This laptop has very good battery backup with battery life of 8 hours. The camera quality of the laptop is very good.",
//            ratingsProduct1,
//            4.3
//        )
//
//        val imageProduct4 = mutableListOf<String>()
//        imageProduct4.add("$baseUrl/images/products/636936e37bedd603de119b05.jpg")
//
//        val product4 = Products("1",
//            "SF Cricket Bat original cricket bat made up of Kashmir willow and with long handle size.",
//            "1900",
//            imageProduct4 as ArrayList<String> /* = java.util.ArrayList<kotlin.String> */,
//            "This bat is the original bat of SS Company. This bat is a kashmir willow cricket bat and is available in long handle size.",
//            ratingsProduct1,
//            4.0
//        )
//
//
//        val imageProduct5 = mutableListOf<String>()
//        imageProduct5.add("$baseUrl/images/products/6369e8fd9637e9b6d8e1c154.jpg")
//
//        val product5 = Products("1",
//            "Nivia brand 1019 Football, Youth Size 5 football for all ages includes vaccum pump",
//            "650",
//            imageProduct5 as ArrayList<String> /* = java.util.ArrayList<kotlin.String> */,
//            "Included Components: Football With Pump, Size Name: 5, Color Map: Multicolour Special Feature: Water Resistant Age Range Description: All Age Groups, Material Type: PU Skill Level: Recreational, Target Audience Base: Adults, Construction Type: Hand Stitched",
//            ratingsProduct1,
//            3.5
//        )
//
//        val productList = mutableListOf<Products>()
//        productList.add(product1)
//        productList.add(product2)
//        productList.add(product3)
//        productList.add(product4)
//        productList.add(product5)
//
//        val linearLayoutManager = LinearLayoutManager(
//            this,
//            LinearLayoutManager.HORIZONTAL, false
//        )
//
//        binding.productRecyclerView.layoutManager = linearLayoutManager
//
//        val recyclerViewMargin = RecyclerViewMargin(12)
//        binding.productRecyclerView.addItemDecoration(recyclerViewMargin)
//
//        binding.productRecyclerView.adapter =
//            ProductAdapter(productList as ArrayList<Products>)
    }

}