package com.example.gmart.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.gmart.MainActivity
import com.example.gmart.R
import com.example.gmart.adapter.RecyclerProdCategory
import com.example.gmart.adapter.RecyclerSpecialForYou
import com.example.gmart.databinding.FragmentHomeBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment() {
    lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
     val binding=FragmentHomeBinding.inflate(inflater,container,false)

        val db = Firebase.firestore

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        homeViewModel.getBanners().observe(viewLifecycleOwner){imageList->
            binding.imageSlider.setImageList(imageList, ScaleTypes.FIT)
        }






        /*val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel("https://bit.ly/2YoJ77H", ScaleTypes.FIT))
        imageList.add(SlideModel("https://bit.ly/2BteuF2", ScaleTypes.FIT))
        imageList.add(SlideModel("https://bit.ly/3fLJf72", ScaleTypes.FIT))*/

        binding.RecViewCat.adapter=RecyclerProdCategory(this.requireContext(),MainActivity.productCategoryList)
            binding.RecViewCat.layoutManager=LinearLayoutManager(this.requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.recViewSpecialForYou.layoutManager=GridLayoutManager(this.requireContext(),2)
        binding.recViewSpecialForYou.adapter=RecyclerSpecialForYou(this.requireContext(),MainActivity.productSpecialForYouList)
        return binding.root
    }
}