package com.example.myapplication2.di.module

import com.example.myapplication2.data.repository.BooksRepositoryImpl
import com.example.myapplication2.data.services.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class BookAppModule {

    @Provides
    fun providesRetrofitApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: ApiService): BooksRepositoryImpl {
        return BooksRepositoryImpl(apiService)
    }
}