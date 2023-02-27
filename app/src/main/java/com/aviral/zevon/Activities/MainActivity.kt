package com.aviral.zevon.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aviral.zevon.Adapter.BrandAdapter
import com.aviral.zevon.Adapter.CategoryAdapter
import com.aviral.zevon.Adapter.ProductAdapter
import com.aviral.zevon.Models.Categories
import com.aviral.zevon.Models.Products
import com.aviral.zevon.Models.Rating
import com.aviral.zevon.R
import com.aviral.zevon.Utils.RecyclerViewMargin
import com.aviral.zevon.databinding.ActivityMainBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val baseUrl: String = "https://zevon.onrender.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCarousel()
        setupBottomNavigation()

        setupBrandAdapter()
        setupCategoryAdapter()
        setupSmartphonesAdapter()
        setupElectronicsAdapter()
        setupWearableAdapter()
        setupBeautyAdapter()
        setupKitchenAdapter()
        setupLaptopAdapter()
        setupAccessoriesAdapter()
        setupSportsAdapter()
        setupFitnessAdapter()
        setupGamesAdapter()
        setupSoftwareAdapter()

    }

    private fun setupSoftwareAdapter() {

    }

    private fun setupGamesAdapter() {

    }

    private fun setupFitnessAdapter() {

    }

    private fun setupSmartphonesAdapter() {

    }

    private fun setupElectronicsAdapter() {

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
//        binding.electronicsRecyclerView.layoutManager = linearLayoutManager
//
//        val recyclerViewMargin = RecyclerViewMargin(12)
//        binding.electronicsRecyclerView.addItemDecoration(recyclerViewMargin)
//
//        binding.electronicsRecyclerView.adapter =
//            ProductAdapter(productList as ArrayList<Products>)

    }

    private fun setupWearableAdapter() {

    }

    private fun setupBeautyAdapter() {

    }

    private fun setupKitchenAdapter() {

    }

    private fun setupLaptopAdapter() {

    }

    private fun setupAccessoriesAdapter() {

    }

    private fun setupSportsAdapter() {

    }



    private fun setupCategoryAdapter() {
        val categoryList = mutableListOf<Categories>()

        categoryList.add(
            Categories(
                "$baseUrl/static/media/smartphones.3f2fa16fa98b3c406a3d.png", "Smartphones"
            )
        )

        categoryList.add(
            Categories(
                "$baseUrl/static/media/electronics.bf8455622dc8cce4cc4c.png", "Electronics"
            )
        )

        categoryList.add(
            Categories(
                "$baseUrl/static/media/wearables.49790f0076bce684ebdf.png", "Wearables"
            )
        )

        categoryList.add(
            Categories(
                "$baseUrl/static/media/beauty.4cb02d85f245e0b71fe8.png", "Beauty"
            )
        )

        categoryList.add(
            Categories(
                "$baseUrl/static/media/kitchen.fa560d2ce8ecb74f0087.png", "Kitchen"
            )
        )

        categoryList.add(
            Categories(
                "$baseUrl/static/media/laptop.722ddeadd4d4c4294f67.png", "Laptop"
            )
        )

        categoryList.add(
            Categories(
                "$baseUrl/static/media/accessories.71f6c6d24bc7779cd7e5.png", "Accessories"
            )
        )

        categoryList.add(
            Categories(
                "$baseUrl/static/media/sports.c4c04b84d7acc60edf16.png", "Sports"
            )
        )

        categoryList.add(
            Categories(
                "$baseUrl/static/media/fitness.e57c71abb9403bf11f3e.png", "Fitness"
            )
        )

        categoryList.add(
            Categories(
                "$baseUrl/static/media/games.ace6cb6429629eb005cd.png", "Games"
            )
        )

        categoryList.add(
            Categories(
                "$baseUrl/static/media/softwares.d297819fda45e00c325a.png", "Softwares"
            )
        )

        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )

        binding.categoriesRecyclerView.layoutManager = linearLayoutManager

        val recyclerViewMargin = RecyclerViewMargin(12)
        binding.categoriesRecyclerView.addItemDecoration(recyclerViewMargin)

        binding.categoriesRecyclerView.adapter =
            CategoryAdapter(categoryList as ArrayList<Categories>)
    }

    private fun setupBottomNavigation() {

        val homeLayout: LinearLayout = findViewById(R.id.btnHome)
        val profileLayout: LinearLayout = findViewById(R.id.btnProfile)
        val contactLayout: LinearLayout = findViewById(R.id.btnContact)
        val settingsLayout: LinearLayout = findViewById(R.id.btnSettings)

        profileLayout.setOnClickListener { startActivity(Intent(this, ProfileActivity::class.java)) }
        contactLayout.setOnClickListener { startActivity(Intent(this, DeveloperProfileActivity::class.java)) }
        settingsLayout.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }


        homeLayout.background = ContextCompat.getDrawable(
            this,
            R.drawable.bottom_navigation_background
        )

        profileLayout.background = ContextCompat.getDrawable(
            this,
            R.drawable.background_white
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

    private fun setupBrandAdapter() {
        val brandList = mutableListOf<String>()

        brandList.add(
            "data:image/png;base64,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"
        )
        brandList.add(
            "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAlgAAAJYCAMAAACJuGjuAAAC+lBMVEVHcEyeo8qDiLWkqMp8gbZobKVudKpobadpbqWHjLprca1jaadgZp6hpsl2e7JVWp1XXaE8RZIzPIwrM4wlLogfKYgYIoQQGn8VHIAKEHwABHQDD3cHEHoGDHsCDHgCB3sAA3kMFHwSGoEaIoAhKIYkMIaxtdB1e61BSJJKUZs5QZMjLYsPGXsNFn8SHIMZH4QdJ4ggKIghKYkhKokjKokjKooiKoghKYgfKIceJYYOF4IQGYYkKodBR5F4fbJgZaVVXJ0qM40cJoIMGX0UH4ULEn8eJYogKIohK4QjK4kUIX4UI4EQHoGFibdMUpg8RZMgKYMYJocbJIUfK4UhLIYgK4sfKYYhKoYhKochKIceKokfK4ckLIodJIQxOYgXIYcdKIUgKIkiKIccJIcpM4gxOY0gK4IdK4MiKYgWIHp3fK9KUZYmL4QYJYMjKYwjLYd8gbJFTZYcJoEIFn4KFHdNVJlKUpkfLoEPHnteZaSnqsxeZKQjK4MeKYwjMYUBCHUlLIwhLokcKoYgLYQLGHoiKIoiKIkYIYAIFHo+RY0iJ4MlLoQ2PYssNIYhL4YkL4sMFHORlcNMU5pBSpcCB3gmLouEiboHEHZiZ6QDEXE8Qo0vOIUvN42zt9UrNIUACXMABHYABHMCDHJ6gLSIi7iQlcAAAHaEiLego8g6QpQDC3ZXXJ0ZIHtVXZ8AAHMjLJCSlsAQGncFDn90ea42P5MABXBpb6lVXJ86Q45OVJqBhbdnbaqHjL7+/vszO5AAAHG7v9j///9zea/09fgAAGkAAG4pMoxLU6CansJVW5xxdLD+//5cY56ipcWTlsSTlsFlbKiRlb+VmrqdochETJmxs9KLjrceKX6tr9BASZjGyd7///y/w9qmqc9tc6rd3un///7//f06RZb29/z+//9cZqf//v7W1+nw8fX//v+yttb9/P3P0eCNk8K5vNPT1eTj5e0vOIj5+frs7fM4P5N6frPo6vI9RZXJzOEuNYcWGoBYYqRDSZdUVpy8BJIsAAAA/nRSTlMABRYyQkZTWnGSkpsnSnGDq8rW5f///////////////////////hE6mrvo+///////////////////////sipgk/D//////////////yOY0vT/////////////////wv///////93////+M4/g////S6r4//+mbP//eB6N7P/////////////6/7r//73o////DLC5//Rh/5D/pK3OF9T/////ezNK/1cpwv+J5Zn//z7+/2nZ/3r/////hP////////////////8d//////////////////////////////////////////////////////////////9/iZ7CNLEi6QMAAB1fSURBVHgB7MHFdcNQAAAw54cZzGyXaf/1ygO01zxJ0VUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACYhOlsvliu1pvtr816tVzMZ9MwieDfwm5/OJ7OlzhJs7woq7pp2i9dP4zFze3dfXw5n46H/e4h+hMIj4en55fXtzEvyw/27OqhjXZpAPggdW9xD+RFvi+k7CzZoWnqoWFJcUiyNG9pUmSri9YLpNS9hbq7e/v3Hbs57ofNyvxun7vHxqrd7tU1NQKKKNb+gUcirBPWZJW6f7/qXev7v3WVSytSgbF/ZP2GjSs2bd7iry8t2xpokD2yKNHfJImyLOPmxmD2tixX1qYVGzesh7+FsaZ5zS2tbdk52e0dnV0hZzgcQfrHJFQyu7dHfb+Wer1trS3N85rgTzGWUrFsx//3lLrbd8oekRAVCelfEYjFYoIUlyKRul2l7s29O5ZVpABjf5Ayp7Kvv9rdOICk0n9MRU9od3DL5r7KOSnA2J69+7at9e8PiXEn0n8D+8MHnA1t7pzd+/ZWALO11KUtjaXuGk0KoOpT6L+SWUcYj6sercadvXvl0lRgdjU4NDzi3ewR1RgpRJlI/x0kQiRCqvWFXKOtY4MpYD+s/ODK0sLgL5KK9D8XlbRDjfmHVx4pB3thR48d91Zv1XxxEul/rk7E8AlpfOeW+uPHmsA+2Pox30S2JkcEREGh2YGxmCyVFg+PrQd7YIvHJqsbNa2DZp/c0Djyy1gTWB9bP1br8ic6wx0y0uw72eELejOG1oO1sdRFZa72iDOGpA9EIk+P99dFqWBdLOVIa36ZFiadYWdjQeuRFLAoNneVo8zp69BU0hlOHeoZWTUXrIg1VRWc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"
        )
        brandList.add("$baseUrl/static/media/sg_logo.7aec9547b1d157b5eb43.png")
        brandList.add("$baseUrl/static/media/adidas_logo.2ea82aba79e8f4a48967.png")

        val gridLayoutManager = GridLayoutManager(this, 2)

        binding.featuredBrandsRecyclerView.layoutManager = gridLayoutManager

        val recyclerViewMargin = RecyclerViewMargin(13)
        binding.featuredBrandsRecyclerView.addItemDecoration(recyclerViewMargin)

        binding.featuredBrandsRecyclerView.adapter =
            BrandAdapter(brandList as ArrayList<String>)

    }

    private fun setupCarousel() {
        val list = mutableListOf<CarouselItem>()

        list.add(CarouselItem("$baseUrl/images/products/6369312b7bedd603de119ab83.webp"))
        list.add(CarouselItem("$baseUrl/images/products/636936e37bedd603de119b05.jpg"))
        list.add(CarouselItem("$baseUrl/images/products/6369312b7bedd603de119ab82.webp"))
        list.add(CarouselItem("https://m.media-amazon.com/images/I/718jPJfWuEL._SX3000_.jpg"))
        list.add(CarouselItem("https://m.media-amazon.com/images/I/71cp9PVuTfL._SX3000_.jpg"))
        list.add(CarouselItem("https://m.media-amazon.com/images/I/61T1M-s6LFL._SX3000_.jpg"))

        binding.carousel.setData(list)
    }

}