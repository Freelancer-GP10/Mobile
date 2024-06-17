package com.example.conecti.data.model

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("id") val id: Int,
    @SerializedName("nome") val nome: String,
    @SerializedName("email") val email: String,
    // Outros campos do usuário, se houver...
)
