package com.example.myapplication2.data.services

import com.example.myapplication2.domain.dataclass.BooksResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("hardcover-fiction.json?api-key=j5GCulxBywG3lX211ZAPkAB8O381S5SM")
    suspend fun getBooks(): Response<BooksResponse>

}