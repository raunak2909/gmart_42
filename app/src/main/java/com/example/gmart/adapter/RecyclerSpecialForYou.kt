package com.example.gmart.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmart.databinding.RowCartRecyclerBinding
import com.example.gmart.databinding.RowSpecialForYouBinding

import com.example.gmart.model.ProductModel
import com.example.gmart.model.ProductSpecialForYouModel

class RecyclerSpecialForYou(val context: Context,val prodList:ArrayList<ProductSpecialForYouModel>):RecyclerView.Adapter<RecyclerSpecialForYou.ViewHolder>() {
    class ViewHolder(val binding:RowSpecialForYouBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(RowSpecialForYouBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
holder.binding.imgProduct.setImageResource(prodList[position].imgProd)
        holder.binding.txtProduct.text=prodList[position].txtProd
        holder.binding.txtAmount.text=prodList[position].prodPrice
        holder.binding.recViewColor.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        holder.binding.recViewColor.adapter=RecycleProdColorSpecialForYou(context,prodList[position].colorList)
    }

    override fun getItemCount(): Int {
        return prodList.size
    }




}