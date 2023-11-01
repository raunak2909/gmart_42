package com.example.gmart.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gmart.MainActivity
import com.example.gmart.R
import com.example.gmart.adapter.RecyclerProdColorAdapter
import com.example.gmart.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductDetailsBinding
    val isSelectedFrag=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recViewColor.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.recViewColor.adapter=RecyclerProdColorAdapter(this,MainActivity.productColorList)

        binding.btnAddToCart.setOnClickListener {
            startActivity(Intent(this@ProductDetailsActivity,MyCartActivity::class.java))
        }
    }
}