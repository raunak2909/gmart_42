package com.example.gmart

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapterProduct(val fm:FragmentManager,val lf:Lifecycle):FragmentStateAdapter(fm,lf) {
    override fun getItemCount(): Int {
return 3
    }

    override fun createFragment(position: Int): Fragment {
      if (position==1){
          return ProductSecondPhotoFragment()
      }
        else if (position==2){
            return ProductThirdPhotoFragment()
      }
        else{
            return ProductFirstPhotoFragment()
      }
    }
}