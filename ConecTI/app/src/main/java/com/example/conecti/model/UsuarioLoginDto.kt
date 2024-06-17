package com.example.conecti.data.model

import com.google.gson.annotations.SerializedName

data class UsuarioLoginDto(
    @SerializedName("email") val email: String,
    @SerializedName("senha") val senha: String
)
