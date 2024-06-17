package com.example.conecti.util

import SharedPrefManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val sharedPrefManager: SharedPrefManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val authToken = sharedPrefManager.fetchAuthToken()
        if (authToken != null) {
            val newRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer $authToken")
                .build()
            return chain.proceed(newRequest)
        }
        return chain.proceed(originalRequest)
    }
}