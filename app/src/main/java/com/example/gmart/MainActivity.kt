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
import com.example.gmart.model.ProductModel


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
        ft.add(R.id.container,fragment)
        ft.commit()
    }
}