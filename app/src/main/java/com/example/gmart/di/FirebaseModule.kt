package com.example.gmart.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class FirebaseModule {

    @Provides
    @Singleton
    fun initFireStore() : FirebaseFirestore{
        return FirebaseFirestore.getInstance();
    }
    //fireStorage
    //fireAuth
    //
    //

}