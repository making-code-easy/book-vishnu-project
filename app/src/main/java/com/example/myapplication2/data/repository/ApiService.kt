package com.example.myapplication2.data.repository

import com.example.myapplication2.domain.dataclass.BooksResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {

    @GET("hardcover-fiction.json?api-key=j5GCulxBywG3lX211ZAPkAB8O381S5SM")
    suspend fun getBooks():Response<BooksResponse>

    companion object{
        fun service(): ApiService{
          return  Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/books/v3/lists/current/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}