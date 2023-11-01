package com.example.gmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.gmart.databinding.ActivityMainBinding
import com.example.gmart.fragment.HomeFragment
import com.example.gmart.model.ProdColorModel
import com.example.gmart.model.ProductCategoryModel
import com.example.gmart.model.ProductModel
import com.example.gmart.model.ProductSpecialForYouModel


class MainActivity : AppCompatActivity() {
    companion object{
        val productColorList=ArrayList<ProdColorModel>().apply {
            add(ProdColorModel("Purple",R.color.purple,false))
            add(ProdColorModel("NavyBlue",R.color.navy_blue,false))
            add(ProdColorModel("Black",R.color.black,false))
            add(ProdColorModel("Mustard",R.color.mustard,false))
        }
        val productCartList=ArrayList<ProductModel>().apply {
         add(ProductModel(R.drawable.tshirt,"T-shirt","Men Fashion","$52.00"))
            add(ProductModel(R.drawable.boat_first,"Headphone","Electronics","$100.00"))
            add(ProductModel(R.drawable.smartwatch,"SmartWatch","Electronics","$150.00"))
        }
        val productCategoryList=ArrayList<ProductCategoryModel>().apply {
            add(ProductCategoryModel(0,R.drawable.mens_wears,"Men"))
            add(ProductCategoryModel(1,R.drawable.women_wear,"Women"))
            add(ProductCategoryModel(2,R.drawable.kids_wea,"Kids"))
            add(ProductCategoryModel(3,R.drawable.makeup,"Beauty"))
            add(ProductCategoryModel(4,R.drawable.jewellery,"Jewellery"))
            add(ProductCategoryModel(5,R.drawable.foot_wear,"Footwear"))
            add(ProductCategoryModel(6,R.drawable.gadget,"Gadgets"))
            add(ProductCategoryModel(7,R.drawable.luggage,"Luggage"))
        }
        val productSpecialForYouList=ArrayList<ProductSpecialForYouModel>().apply {
            add(ProductSpecialForYouModel(1,"200",R.drawable.tshirt,"T-shirt", productColorList))
            add(ProductSpecialForYouModel(2,"300",R.drawable.boat_first,"Headphone", productColorList))
            add(ProductSpecialForYouModel(3,"500",R.drawable.smartwatch,"SmartWatch", productColorList))
            add(ProductSpecialForYouModel(4,"200",R.drawable.tshirt,"T-shirt", productColorList))
            add(ProductSpecialForYouModel(5,"300",R.drawable.boat_first,"Headphone", productColorList))
            add(ProductSpecialForYouModel(6,"500",R.drawable.smartwatch,"SmartWatch", productColorList))
            add(ProductSpecialForYouModel(7,"200",R.drawable.tshirt,"T-shirt", productColorList))
            add(ProductSpecialForYouModel(8,"300",R.drawable.boat_first,"Headphone", productColorList))
            add(ProductSpecialForYouModel(9,"500",R.drawable.smartwatch,"SmartWatch", productColorList))
        }
    }
    lateinit var binding:ActivityMainBinding
    lateinit var fm:FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fm=supportFragmentManager
        loadFrag(HomeFragment())
        binding.btnHome.setOnClickListener{
            loadFrag(HomeFragment())
        }
       // binding.bottomNavBar.background = null
        binding.btnDrawer.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }


    }
    fun loadFrag(fragment: Fragment){
        val ft=fm.beginTransaction()
        ft.replace(R.id.container,fragment)
        ft.commit()
    }
}