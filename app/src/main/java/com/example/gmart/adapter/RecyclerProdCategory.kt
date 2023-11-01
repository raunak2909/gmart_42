package com.example.gmart.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmart.databinding.RowProdCatBinding
import com.example.gmart.model.ProductCategoryModel

class RecyclerProdCategory(val context: Context,val productList: ArrayList<ProductCategoryModel>):RecyclerView.Adapter<RecyclerProdCategory.ViewHolder>() {
 class ViewHolder(val  binding: RowProdCatBinding):RecyclerView.ViewHolder(binding.root){

 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowProdCatBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
       return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.imgCat.setImageResource(productList[position].catImage)
        holder.binding.txtCat.text=productList[position].catName
    }
}
