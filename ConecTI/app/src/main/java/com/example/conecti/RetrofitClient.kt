package com.example.conecti

import ApiService
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory


object RetrofitClient {
    private const val BASE_URL = "http://192.168.18.60:8080"

    fun connection(): ApiService {
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory()) // Adicionando o adaptador de chamada para Coroutines
            .build()
        return retrofit.create(ApiService::class.java)
    }
}
