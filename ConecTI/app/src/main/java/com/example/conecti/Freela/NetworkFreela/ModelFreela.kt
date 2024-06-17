package com.example.conecti.Freela.NetworkFreela

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.conecti.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelFreela(private val context: Context?) : ViewModel() {
    private val apiService = RetrofitClient.connection()
    var erroApi = MutableLiveData("")

    fun cadastrarFreelancer(freelaDto: ServiceFreela.freelaDetailsDto) {
        apiService.cadastrarFreelancer(freelaDto).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    println("Freelancer cadastrado com sucesso")
                } else {
                    println("Erro ao cadastrar freelancer: ${response.errorBody()?.string()}")
                    erroApi.postValue("Erro ao cadastrar freelancer: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                println("Falha ao cadastrar freelancer: ${t.message}")
                erroApi.postValue("Falha ao cadastrar freelancer: ${t.message}")
            }
        })
    }
}
