package com.example.interviewproject.data.dependency_injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
/*
    @Provides
    @Singleton
    fun provide...() : ... {
        return ....Builder()
            .baseUrl(?)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(?)
    }
 */
}