package com.example.myapplication2.di.module

import com.example.myapplication2.di.scope.ApplicationScope
import com.example.myapplication2.utils.BookAppConstant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    @ApplicationScope
    @Provides
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BookAppConstant.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @ApplicationScope
    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}