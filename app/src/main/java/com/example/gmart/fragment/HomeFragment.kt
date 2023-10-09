package com.example.gmart.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.gmart.R
import com.example.gmart.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
     val binding=FragmentHomeBinding.inflate(inflater,container,false)
        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel("https://bit.ly/2YoJ77H", ScaleTypes.FIT))
        imageList.add(SlideModel("https://bit.ly/2BteuF2", ScaleTypes.FIT))
        imageList.add(SlideModel("https://bit.ly/3fLJf72", ScaleTypes.FIT))
        binding.imageSlider.setImageList(imageList,ScaleTypes.FIT)
        return binding.root
    }
}