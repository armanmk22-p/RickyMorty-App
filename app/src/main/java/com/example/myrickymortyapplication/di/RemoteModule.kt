package com.example.rickandmorty.di

import com.example.myrickymortyapplication.data.repository.RickyMortyImpl
import com.example.myrickymortyapplication.data.resource.remote.RickyMortyApi
import com.example.myrickymortyapplication.data.util.Constans
import com.example.myrickymortyapplication.domain.repository.RickyMorty
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickyMortyApi {
        return Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickyMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: RickyMortyApi): RickyMorty {
        return RickyMortyImpl(api)
    }
}