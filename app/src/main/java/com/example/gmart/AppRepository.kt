package com.example.gmart

import androidx.lifecycle.MutableLiveData
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AppRepository {
    var bannerList = MutableLiveData<ArrayList<SlideModel>>()
    companion object{
        const val COLLECTION_BANNERS = "banners"
    }

    fun getBanners() : MutableLiveData<ArrayList<SlideModel>>{
        val db = Firebase.firestore
        db.collection(AppRepository.COLLECTION_BANNERS).get().addOnSuccessListener {

            val imageList = ArrayList<SlideModel>()

            for (eachBanner in it.documents){
                imageList.add(SlideModel(eachBanner.get("img").toString(), ScaleTypes.FIT))
            }

            bannerList.postValue(imageList)
        }
        return bannerList
    }

}