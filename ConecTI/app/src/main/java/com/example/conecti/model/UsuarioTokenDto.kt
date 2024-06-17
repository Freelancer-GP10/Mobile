package com.example.conecti.data.model

import com.google.gson.annotations.SerializedName

data class UsuarioTokenDto(
    @SerializedName("token") val token: String,
    @SerializedName("usuario") val usuario: Usuario
)
