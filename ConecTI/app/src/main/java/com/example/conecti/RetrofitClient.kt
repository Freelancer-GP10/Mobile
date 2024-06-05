package com.example.conecti

import ApiService
import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import tokenUsuario


object RetrofitClient {
    const val BASE_URL = "http://3.88.148.30:80/api"

    var context:Context? = null


    fun connection(): ApiService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()

                 var token:String? = null;

                runBlocking {
                    if(getToken()!=null){
                        token= getToken()
                    }
                }
                val newRequest = if (token != null) {
                    originalRequest.newBuilder()
                        .header("Authorization", " $token")
                        .build()
                } else {
                    originalRequest
                }
                chain.proceed(newRequest)
            }
            .build()

        val cliente = Retrofit.Builder()
            .baseUrl("$BASE_URL/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
        return cliente
    }
    suspend fun getToken(): String? {
        val token = stringPreferencesKey("token")
        val preferences = context?.tokenUsuario?.data?.first()
        return preferences?.get(token)
    }
}
