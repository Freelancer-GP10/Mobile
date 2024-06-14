package com.example.conecti

import ApiService
import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import tokenUsuario

object RetrofitClient {

    const val BASE_URL = "http://3.84.147.198/api"
    var context: Context? = null


    @SuppressLint("StaticFieldLeak")
    fun connection(): ApiService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()

                 var token:String? = null;

//                runBlocking {
//                    if(context?.let { getToken(it) } !=null){
//                        token= getToken(context!!)
//                    }
//                }

                runBlocking {
                    token = context?.let { getToken(it) } // Alteração: Correção na forma de recuperar o token
                }

                val newRequest = if (token != null) {
                    originalRequest.newBuilder()
                        .header("Authorization", "Bearer $token")
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
    suspend fun getToken(context: Context): String? {
        val token = stringPreferencesKey("token")
        val preferences = context.tokenUsuario.data.first()
        return preferences?.get(token)
    }
}
