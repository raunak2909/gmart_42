package com.example.gmart.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.gmart.AppRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val appRepository = AppRepository()

    var bannerList = MutableLiveData<ArrayList<SlideModel>>()


    fun getBanners() : MutableLiveData<ArrayList<SlideModel>>{
        bannerList = appRepository.getBanners()
        return bannerList
    }





}