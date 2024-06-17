package com.example.conecti.Micro.NetworkMicro

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call
interface ApiServiceMicro {
    @POST("cadastrarFreelancer")
    fun cadastrarFreelancer(@Body freelaDto: ServiceMicro): Call<Void>
}