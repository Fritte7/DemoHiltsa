package com.fritte.demohiltsa.data.network

import com.fritte.demohiltsa.data.utils.CustomDateAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object NetworkAPI {

    @Provides
    fun provideAPI() : INetworkAPI {
        val moshiBuilder = Moshi.Builder().add(CustomDateAdapter())
        return Retrofit.Builder()
            .baseUrl("https://5ef33fdb25da2f0016228cd5.mockapi.io/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshiBuilder.build()))
            .build()
            .create(INetworkAPI::class.java)
    }
}
